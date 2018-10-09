package com.sapient.sapestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient



@SpringBootApplication
public class User {

	public static void main(String[] args) {
		SpringApplication.run(User.class, args);
	}
}