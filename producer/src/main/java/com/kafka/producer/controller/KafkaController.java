package com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.model.Course;
import com.kafka.producer.service.KafkaService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        String response = kafkaService.sendMessage(course); // Call service to send message to Kafka
        return new ResponseEntity<String>(response, HttpStatus.OK); // Return response to client
    }
}
    

