package com.example.kafka.kafkaCustomObjectDemo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.kafkaCustomObjectDemo.kafka.KafkaProducer;
import com.example.kafka.kafkaCustomObjectDemo.kafka.MessageRepository;
import com.example.kafka.kafkaCustomObjectDemo.util.User;

@RestController
public class KafkaRest {

	@Autowired
	private KafkaProducer producer;
	
	@Autowired
	private MessageRepository repository;
	
	@GetMapping("/push")
	public String pushCustomObjectToKafka() {
		for(int i=1;i<=1000;i++) {
		User user= new User(i,"Chetan","Jalgaon");
		producer.produce(user);
		}
		return "object pushed to kafka successfully......";
	}
	
	@GetMapping("/consume")
	public List<User> getUsersFromKafka(){
		
		return repository.getUsers();
		
	}
	private User createUser() {
		
		Random random =  new Random();
		int no = random.nextInt(90)+10;
		User user = new User(no,"name:"+no,"Jalgaon");
		return user;
	}
	@GetMapping("/send")
	@Scheduled(cron="* * * * *")
	public String sendCustomObjectToKafka() {
		
		User user=  createUser();
		producer.produce(user);
		
		return "scheduled object pushed to kafka successfully......";
	}
	
	
	
}
