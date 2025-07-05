package com.example.kafka.kafkaCustomObjectDemo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.kafka.kafkaCustomObjectDemo.util.User;

@Configuration
public class ProducerConfig {

	Map<String, Object> config = new HashMap<>();
	
	
	public ProducerFactory<String,User> producerFactory(){
		
		config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
                "127.0.0.1:9092");
		config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
		
	}
	
	 @Bean
	  
	    // Method 
	    public KafkaTemplate kafkaTemplate() 
	    { 
	  
	        return new KafkaTemplate<>(producerFactory()); 
	    }

	
}
