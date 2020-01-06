package eu.albertomorales.training.acmenet.lockedCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import eu.albertomorales.training.acmenet.lockedCard.dto.LockedCardImpl;

@Service
public class LockedCardProducer {
		
	public void send(String key, LockedCardImpl event) {
	    kafkaTemplate.send(topic_name, key, event);
	}
	
	@Autowired
	private KafkaTemplate<String, LockedCardImpl> kafkaTemplate;
	
    @Value(value = "${lockedCard.topic-name}")	
	private String topic_name;

}