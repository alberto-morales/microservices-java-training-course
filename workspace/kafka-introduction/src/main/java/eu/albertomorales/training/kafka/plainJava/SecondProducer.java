package eu.albertomorales.training.kafka.plainJava;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;

public class SecondProducer {
	
	private final String BOOTSTRAP_SERVERS = "192.168.1.80:9092";
	private final String TOPIC_NAME = "curso";
	
	private void doIt() throws InterruptedException {
		Properties prop = new Properties();
		prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		prop.setProperty(ProducerConfig.CLIENT_ID_CONFIG, "CLI1");
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.IntegerSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");		
		Producer<Integer, String> producer = new KafkaProducer<Integer, String>(prop);
		int n = 0;
		while (n < 100) {
			String value = "Evento "+ new Date();
			ProducerRecord<Integer, String> event 
				= new ProducerRecord<Integer, String> (TOPIC_NAME, n, value);
			producer.send(event);
		    System.out.printf("Producer Record:(%d, %s, %d)\n",
		    		event.key(), event.value(),
		    		event.partition());
		    n++;
			Thread.sleep(2000);		    
		}
		producer.close();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		SecondProducer producer = new SecondProducer();
		producer.doIt();
	}

}
