package eu.albertomorales.training.kafka.plainJava;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;

public class FirstProducer {
	
	private final String BOOTSTRAP_SERVERS = "192.168.1.80:9092";
	private final String TOPIC_NAME = "curso";
	
	private void doIt() {
		Properties prop = new Properties();
		prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		prop.setProperty(ProducerConfig.CLIENT_ID_CONFIG, "CLI1");
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");		
		Producer<String, String> producer = new KafkaProducer<String, String>(prop);
		String value = "Evento "+ new Date();
		ProducerRecord<String, String> event 
			= new ProducerRecord<String, String> (TOPIC_NAME, value);
		producer.send(event);
		producer.close();
	}
	
	
	public static void main(String[] args) {
		FirstProducer producer = new FirstProducer();
		producer.doIt();
	}

}
