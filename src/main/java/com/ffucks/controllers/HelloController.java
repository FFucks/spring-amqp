package com.ffucks.controllers;

import com.ffucks.producers.HelloProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloProducer producer;

    public HelloController(HelloProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String hello() {
        producer.send();
        return "Message sent!!!";
    }
}
