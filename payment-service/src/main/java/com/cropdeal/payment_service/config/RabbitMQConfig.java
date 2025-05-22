package com.cropdeal.payment_service.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;


@Configuration
public class RabbitMQConfig {

    @Value("${payment.queue.name}")
    private String queue;

    @Bean
    public Queue paymentQueue() {
        return new Queue(queue, false);
    }
}

