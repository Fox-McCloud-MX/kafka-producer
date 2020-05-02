package com.mx.kafka.controller;


import com.mx.kafka.config.KafkaProducerConfig;
import com.mx.kafka.enity.User;
import com.mx.kafka.enity.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("kafka")
public class ProducerController {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    KafkaProducerConfig kafkaProducerConfig;

    private static final String TOPIC = "github-topic";

    @PostMapping
    public UserResponse post(@RequestBody User user) {
        kafkaTemplate.send(TOPIC, user);

        return new UserResponse(
                HttpStatus.OK,
                "User created successfully",
                user
        );
    }
}
