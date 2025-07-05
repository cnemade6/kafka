package com.example.kafka.kafkaCustomObjectDemo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.kafka.kafkaCustomObjectDemo.util.User;

@Component
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, User> template;
	
	public void produce(User user) {
		System.out.println("pushing user to kafka.........");
		template.send("customTopic", user);
		System.out.println("user pushed to kafka successfully........");
		
	}
	
	
	
}
