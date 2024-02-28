package com.examplewebclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ExamplewebclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplewebclientApplication.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl("http://localhost:8081/api").build();
	}

}
