package com.learner.learnrabbitmq.controller;

import com.learner.learnrabbitmq.publisher.RabbitMQPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQPublisher rabbitMQPublisher;

    public MessageController(RabbitMQPublisher rabbitMQPublisher) {
        this.rabbitMQPublisher = rabbitMQPublisher;
    }

    //http://localhost:8080/api/v1/publish?message=hello-world
    @GetMapping("/publish")
    public ResponseEntity<String> getMessage(@RequestParam("message") String message){
        rabbitMQPublisher.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ......");
    }
}
