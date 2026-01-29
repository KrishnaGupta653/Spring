package com.telusko.myApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.PropertyMapper.Source.Always;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    //Dependency Injection via Field Injection
    //Always prefer constructor injection.

    // //1. Field Injection
    // // @Autowired
    // private Laptop laptop;

    // //2. Constructor Injection
    // public Dev(Laptop laptop){
    //     this.laptop = laptop;
    // }

    // // //3. Setter Injection
    // // @Autowired
    // // public void setLaptop(Laptop laptop){
    // //     this.laptop = laptop;
    // // }

    private Computer computer;
    //public Dev(Laptop laptop  ){  //Tight Coupling
    // ❌ Dev(Laptop laptop) → “I only accept Laptop”
    // ✅ Dev(Computer computer) → “I accept any computer”
    // Choose implementation using:
    
    //1.
    // @Primary (default)
    //@Primary
    // @Component
    // public class Laptop implements Computer { }
    
    //2. @Qualifier (specific)
    // public Dev(@Qualifier("desktop") Computer computer)
    
    //3. @Profile (environment)
    // @Profile("dev") → Laptop
    // @Profile("prod") → Desktop

    public Dev(@Qualifier("laptop") Computer computer){
        this.computer = computer;
    }

    public void build(){
        computer.compileCode();
        System.out.println("Building the project...");
    }
    public void test(){
        System.out.println("Testing the project...");
    }
    public void deploy(){
        System.out.println("Deploying the project...");
    }

    
    
    
}
