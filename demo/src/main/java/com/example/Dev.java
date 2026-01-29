package com.example;

import org.springframework.stereotype.Component;

@Component
public class Dev {
    //private Laptop laptop;
    private int age=0;
    private int id=0;

    private Laptop laptop;
    public Dev(){
        System.out.println("Dev constructor called");
    }
    public void build(){
        System.out.println("Building the project...");
        laptop.compile();
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Dev(int age) {
        this.age = age;
        System.out.println("Dev 1: age constructor called");
    }
    
    public Dev(int age,int id ) {
        this.age= age;
        this.id= id;
        System.out.println("Dev 2: age and id constructor called");
    }
    public Dev(Laptop laptop ) {
        this.laptop= laptop;
        System.out.println("Dev 3: laptop constructor called");
    }   

    
    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    
    







}


