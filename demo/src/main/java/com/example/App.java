package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        //1
        //Dev obj=context.getBean(Dev.class); //byType
        //ob.build();

        //2
        // Dev obj=(Dev)context.getBean("dev"); //byId
        // obj.build();

        
        Dev obj=(Dev)context.getBean("dev");
        obj.build();
        
        //1
        // obj.setAge(25);
        //2
        //age is injected by spring using spring.xml configuration
        // System.out.println("Age: " + obj.getAge());
        // System.out.println("ID: " + obj.getId());



        System.out.println( "Hello World!" );

    }
}
