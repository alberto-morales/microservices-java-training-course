package eu.albertomorales.training.acmenet.lockedCard;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import eu.albertomorales.training.acmenet.lockedCard.dto.LockedCardImpl;

@EnableKafka
@Configuration
public class LockedCardConsumerConfig {

    @Bean
    public ConsumerFactory<String, LockedCardImpl> lockedCardConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        final JsonDeserializer<LockedCardImpl> jsonDeserializer = new JsonDeserializer<LockedCardImpl>();
        jsonDeserializer.addTrustedPackages("*");        
        return new DefaultKafkaConsumerFactory<String, LockedCardImpl>(props, new StringDeserializer(), jsonDeserializer);
    }
 
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LockedCardImpl> lockedCardKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, LockedCardImpl> factory = new ConcurrentKafkaListenerContainerFactory<String, LockedCardImpl>();
        factory.setConsumerFactory(lockedCardConsumerFactory());
        return factory;
    }
    
    @Value(value = "${kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${lockedCard.group-id}")
    private String groupId;    
    
}
