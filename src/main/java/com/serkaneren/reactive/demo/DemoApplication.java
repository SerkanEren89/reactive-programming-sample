package com.serkaneren.reactive.demo;

import com.serkaneren.reactive.demo.client.PersonWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		PersonWebClient personWebClient = new PersonWebClient();
		System.out.println(personWebClient.getResult());
	}

}
