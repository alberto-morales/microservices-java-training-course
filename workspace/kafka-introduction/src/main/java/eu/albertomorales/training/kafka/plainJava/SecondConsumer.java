package eu.albertomorales.training.kafka.plainJava;

import java.util.Collections;
import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class SecondConsumer {
	
	private Consumer<Long, String> createConsumer(String consumerGroup) {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
		                            BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG,
					  (consumerGroup == null || consumerGroup.isEmpty())
					  ? GROUP_ID
					  : consumerGroup);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
		        IntegerDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
		        StringDeserializer.class.getName());
		
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.FALSE);
		
		  // Create the consumer using props.
		final Consumer<Long, String> consumer =
		                            new KafkaConsumer<>(props);
		
		// Subscribe to the topic.
		consumer.subscribe(Collections.singletonList(TOPIC_NAME));
		return consumer;
	}

	private void doIt(String consumerGroup) throws InterruptedException {
        Consumer<Long, String> consumer = createConsumer(consumerGroup);
        final int giveUp = 100;   
        int noRecordsCount = 0;

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords =
                    consumer.poll(10);

            if (consumerRecords.count()==0) {
                noRecordsCount++;
                Thread.sleep(1000);
                if (noRecordsCount > giveUp) break;
                else continue;
            }

            consumerRecords.forEach(record -> {
                System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());
            });

            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("DONE");
    }
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Introduce CONSUMER_GROUP name:");
		Scanner keyboard = new Scanner(System.in);
		String consumerGroup = keyboard.next();
		keyboard.close();
		SecondConsumer consumer = new SecondConsumer();
		consumer.doIt(consumerGroup);
	}
	
	private final String BOOTSTRAP_SERVERS = "localhost:9092";
	private final String TOPIC_NAME = "curso";
	private final String GROUP_ID = "KafkaExampleConsumer";	
	
}
