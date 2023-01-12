package com.demo.kafka.controller;

import com.demo.kafka.payload.User;
import com.demo.kafka.service.KafKaConsumer;
import com.demo.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private static final String TOPIC = "NewTopic";
    @Autowired
    KafkaProducer kafkaProducer;
    @Autowired
    KafKaConsumer kafKaConsumer;

    @PostMapping("/producer")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
    }

}