package com.ffucks.consumers;

import com.rabbitmq.client.*;

public class OrderConsumer {

    private static final String QUEUE = "orders-created-queue";
    private static final String EXCHANGE = "orders-exchange";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QUEUE, true, false, false, null);
        channel.queueBind(QUEUE, EXCHANGE, "order.created");

        System.out.println("Waiting for messages...");

        DeliverCallback callback = (tag, delivery) -> {
            String msg = new String(delivery.getBody());
            System.out.println("Received: " + msg);
        };

        channel.basicConsume(QUEUE, true, callback, tag -> {});
    }
}
