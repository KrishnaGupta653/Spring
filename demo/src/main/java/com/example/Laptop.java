package com.example;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    public Laptop(){
        System.out.println("Laptop constructor called");
    }

    public void compile(){
        System.out.println("Compiling the code on laptop...");
    }   
    
}
