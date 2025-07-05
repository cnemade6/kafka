package com.example.kafka.kafkaCustomObjectDemo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.kafka.kafkaCustomObjectDemo.util.User;

@Component
public class KafkaReceiver {
	
	@Autowired
	private MessageRepository repository;
@KafkaListener(topics="customTopic",groupId ="xyz", containerFactory = "userListner")
	public void consume(User user) {
	repository.addUser(user);
	//repository.setUser(user);
		System.out.println("custom object consumed from kafka is= "+user);
		
	}
}
