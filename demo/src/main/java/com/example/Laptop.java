package com.example;
public class Laptop implements Computer {
    public Laptop(){
        System.out.println("\nLaptop constructor called \n");
    }

    public void compile(){
        System.out.println("\nCompiling the code on laptop...\n");
    }   
    
}
