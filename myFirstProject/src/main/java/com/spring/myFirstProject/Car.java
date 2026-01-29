package com.spring.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController //defines a class as a RESTful web service controller, capable of handling HTTP requests and returning responses in a RESTful manner.
public class Car {
    @Autowired //Dependency Injection (DI) is a design pattern used to implement IoC, allowing the creation of dependent objects outside of a class and providing those objects to a class in various ways.
    private Dog dog; //Dog is a bean here, as it is managed by the Spring IoC container.

    public String carFun() {
        return "Car is fun! " + dog.fun();
    }

    @GetMapping("/ok")
    public String okij(){
        return dog.fun();
    }
    @GetMapping("/car")
    public String car(){
        return carFun();
    }
    
}
