package com.ffucks.producers;

import com.rabbitmq.client.*;

public class OrderProducer {

    private static final String EXCHANGE = "orders-exchange";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.TOPIC);

            String routingKey = "order.created";
            String message = "Order 123 created";

            channel.basicPublish(
                    EXCHANGE,
                    routingKey,
                    null,
                    message.getBytes()
            );

            System.out.println("📤 Sent: " + message);
        }
    }
}
