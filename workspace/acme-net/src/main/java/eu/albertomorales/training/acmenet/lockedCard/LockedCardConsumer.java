package eu.albertomorales.training.acmenet.lockedCard;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import eu.albertomorales.training.acmenet.lockedCard.dto.LockedCardImpl;

@Component
public class LockedCardConsumer {

	@KafkaListener(containerFactory = "lockedCardKafkaListenerContainerFactory", topics = "${lockedCard.topic-name}")
	//    , groupId = "${kafka.lockedCard.group.name}"
	public void listen(@Payload LockedCardImpl lockedCard,
		@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
		// TODO something like.. send events to a permanent event store?
		System.out.println("Hemos recibido solicitud de lock del key (PAN) '"+key+"' con motivo '"+lockedCard.getReason()+"'");
	}
		   
}
