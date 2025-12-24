Spring AMQP

Advanced Message Queuing Protocol (AMQP) support for Spring applications.

It is a messaging protocol used for asynchronous communication between systems.

Key AMQP Concepts
🔹 Producer

The sender of messages.
🔹 Consumer

The receiver of messages.
🔹 Broker

Message server (e.g., RabbitMQ).
🔹 Exchange

Responsible for routing messages.
🔹 Queue

Queue where the message is stored.
🔹 Binding


🔀 Exchange Types

1️⃣ Direct
 * Routes by exact routing key
 * routingKey = "order.created"

2️⃣ Topic (most used)
 * Routes by patterns
 * order.* order.created order.cancelled

3️⃣ Fanout
 * Ignores routing key → sends to all queues

4️⃣ Headers
 * Based on headers (less common)