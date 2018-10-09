package com.sapestore.bookapp;
/**
 * @author harsriva1

 *
 */
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class BookStoreServiceApplication {

	public static void main(String[] args) {
		System.out.println("========================>inside main========================>");
		SpringApplication.run(BookStoreServiceApplication.class, args);
	}


@Bean
	
	public RestTemplate template() {
		return new RestTemplate();
	}
}
