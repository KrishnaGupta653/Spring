package com.example;

public class Desktop implements Computer {
    public Desktop(){
        System.out.println("\nDesktop constructor called\n");
    }
    
    public void compile(){
        System.out.println("\nCompiling the code on desktop...\n");
    }
}
