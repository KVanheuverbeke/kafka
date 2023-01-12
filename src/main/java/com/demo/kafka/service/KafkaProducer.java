package com.demo.kafka.service;

import com.demo.kafka.payload.User;
import com.demo.kafka.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data){
        log.info(String.format("Message sent -> %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
        //kafkaTemplate.send(AppConstants.TOPIC_NAME,data);
    }

}