package com.telusko.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(MyAppApplication.class, args); // this will return the IOC container and ApplicationContext is the interface which is implemented by the IOC container 
		//ApplicationContext context  will create the object of Dev class and will keep it in the container but not like this 
		// Dev developer = new Dev();

		Dev developer = context.getBean(Dev.class);
		//Spring controls object creation
		//This is Inversion of Control:
		//Instead of YOU creating objects, Spring creates and manages them.
		developer.build();
	}

}
