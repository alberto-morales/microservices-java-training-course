package eu.albertomorales.training.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.albertomorales.training.kafka.producer.KafkaTestProducer;

@RestController
public class KafkaTestController {

	@Autowired
	KafkaTestProducer kafkaProducer;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam(required = false, name="message") String message) {
		kafkaProducer.send(message);
		return "Message sent to the Kafka Topic 'curso' Successfully";
	}

}
	