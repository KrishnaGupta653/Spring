package com.spring.myFirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //main class
//enables auto-configuration and component scanning in Spring Boot applications
//it indicates that this is the main class for a Spring Boot application.
//it triggers the auto-configuration mechanism of Spring Boot, which automatically configures various components based on the dependencies present in the classpath.
//@SpringBootApplication is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. 
public class MyFirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstProjectApplication.class, args);
	}

} 
