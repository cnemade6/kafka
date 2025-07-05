package com.example.kafka.kafkaCustomObjectDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaCustomObjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaCustomObjectDemoApplication.class, args);
	}

}
