package com.telusko.myApp;
import org.springframework.stereotype.Component;
@Component
public class Laptop implements Computer {
    public void compileCode(){
        System.out.println("Compiling the code on Laptop...");
    }
}
