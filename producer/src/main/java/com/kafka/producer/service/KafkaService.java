package com.kafka.producer.service;
import org.springframework.stereotype.Service;

import com.kafka.producer.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate; // Inject KafkaTemplate
    public String sendMessage(Course course) {
        kafkaTemplate.send("telusko","course", course); // Send message to Kafka topic
        return "Message sent to Kafka topic successfully!";
    }

    
}
