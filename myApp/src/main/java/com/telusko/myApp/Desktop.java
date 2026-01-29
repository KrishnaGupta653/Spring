package com.telusko.myApp;
import org.springframework.stereotype.Component;

@Component  
public class Desktop implements Computer {
    public void compileCode(){
        System.out.println("Compiling the code on Desktop...");
    }

}
