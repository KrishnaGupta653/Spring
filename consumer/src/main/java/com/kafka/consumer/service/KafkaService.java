package com.kafka.consumer.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.model.Course;
@Service
public class KafkaService {
    private String message;
    @KafkaListener(
        topics = "telusko", 
        groupId = "consumer-id-new"
    )
    public void receiveMessage(Course course) {
        message=course+"Got the data from kafka topic";
        System.out.println("Received Course: " + course);
        
    }
    public String getMessage() {
    return message == null ? "No message received yet" : message;
}

}
