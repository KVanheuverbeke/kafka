package com.demo.kafka.service;

import com.demo.kafka.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@EnableScheduling
@Slf4j
public class ScheduledTasks {

    private final KafkaProducer kafkaProducer;

    public ScheduledTasks(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //every tuesday morning at 0:15 am
    //@Scheduled(cron = "0 5 0 * * 1")
    //@PostConstruct
    @Scheduled(fixedRate = 1000)
    public void send() {
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextInt(1, 1000));
        user.setFirstName(RandomStringUtils.random(5, true, false));
        user.setLastName(RandomStringUtils.random(10, true, false));
        kafkaProducer.sendMessage(user);
    }

}