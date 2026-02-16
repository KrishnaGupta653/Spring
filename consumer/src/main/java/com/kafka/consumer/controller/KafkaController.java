package com.kafka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.service.KafkaService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/getCourse")
    public ResponseEntity<String> getCourse() {
        String response = kafkaService.getMessage(); 
        return new ResponseEntity<String>(response, HttpStatus.OK); // Return response to client
    }
}
    

