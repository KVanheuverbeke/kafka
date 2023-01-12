package com.demo.kafka.service;

import com.demo.kafka.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafKaConsumer {

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));
    }

}