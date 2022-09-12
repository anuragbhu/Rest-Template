package com.example.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/*
		If we want to use any piece of code. Then we need to create the object of that piece of
		code. In order to create the object of that piece of code, we need to create a function
		which will return or expose the object of that RestTemplate.

		As soon as we run this application, the object is created and available in the application
		context. So, that whenever we want to use that object. We can use that object.

		We need to annotate with Bean annotation.
	 */

}
