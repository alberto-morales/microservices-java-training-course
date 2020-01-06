package eu.albertomorales.training.acmenet.lockedCard;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import eu.albertomorales.training.acmenet.lockedCard.dto.LockedCardImpl;

@Configuration
public class LockedCardProducerConfig {

	@Bean
    public ProducerFactory<String, LockedCardImpl> lockedCardProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String, LockedCardImpl>(configProps);
    }
 
    @Bean
    public KafkaTemplate<String, LockedCardImpl> lockedCardKafkaTemplate() {
        return new KafkaTemplate<String, LockedCardImpl>(lockedCardProducerFactory());
    }
    
    @Value(value = "${kafka.bootstrap-servers}")
    private String bootstrapAddress;
    
}
