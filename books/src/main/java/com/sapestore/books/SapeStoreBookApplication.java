package com.sapestore.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class SapeStoreBookApplication {
	/*
	@Autowired
	EntityManagerFactory factory;*/

	public static void main(String[] args) {
		SpringApplication.run(SapeStoreBookApplication.class, args);
	}
	
	/*@Bean
	public SessionFactory getSessionFactory()
	{
		if(factory.unwrap(SessionFactory.class)==null) {
			throw new NullPointerException("is not a hibernate factory");
		}
		return factory.unwrap(SessionFactory.class);
	} */
@Bean
	
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	
	}
