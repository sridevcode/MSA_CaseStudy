package com.retail.customerservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {

    private final ConnectionFactory connectionFactory;

    @Autowired
    public RabbitConfig(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

/*    @Bean
    public RabbitTemplate template() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory);
        rabbitTemplate.setRoutingKey("spring-boot");
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }*/
}
