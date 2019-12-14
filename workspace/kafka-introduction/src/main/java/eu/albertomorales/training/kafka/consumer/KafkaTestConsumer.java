package eu.albertomorales.training.kafka.consumer;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestConsumer {

	@KafkaListener(topics = "${message.topic.name}", groupId = "${message.group.name}")
	 public void listenTopic1(List<String> receivedMessages) {
		 for (String message : receivedMessages) {
		     System.out.println("Received message in  listener: '" + message + "'");			 
		 }
	 }
		   
}
