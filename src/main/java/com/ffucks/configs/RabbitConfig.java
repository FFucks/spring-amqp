package com.ffucks.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "hello.queue";
    public static final String EXCHANGE = "hello.exchange";
    public static final String ROUTING_KEY = "hello.key";

    //Durable false if rabbitMQ restart que queue disapears
    @Bean
    Queue queue() {
        return new Queue(QUEUE, false);
    }

    //Direct exchange, the message will only be queued if the routing key matches exactly.
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

}
