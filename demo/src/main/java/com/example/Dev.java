package com.example;
public class Dev {
    //private Laptop laptop;
    // private int age=0;
    // private int id=0;

    //private Laptop laptop;


    public Dev(){
        System.out.println("\nDev constructor called\n");
    }

    public void build(){
        System.out.println("\nBuilding the project...\n");
        //laptop.compile();
        comp.compile();
    }
    // public int getAge() {
    //     return age;
    // }
    // public void setAge(int age) {
    //     this.age = age;
    // }
    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public Dev(int age) {
    //     this.age = age;
    //     System.out.println("\nDev 1: age constructor called\n");
    // }
    
    // public Dev(int age,int id ) {
    //     this.age= age;
    //     this.id= id;
    //     System.out.println("\nDev 2: age and id constructor called\n");
    // }
    
    

    // public Dev(Laptop laptop ) {
    //     this.laptop= laptop;
    //     System.out.println("\nDev 3: laptop constructor called\n");
    // }   

    
    // public Laptop getLaptop() {
    //     return laptop;
    // }
    // public void setLaptop(Laptop laptop) {
    //     this.laptop = laptop;
    // }
    
    private Computer comp;

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    







}


