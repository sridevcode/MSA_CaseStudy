package com.retail.salesorderservice;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CustomerSOSController {
	
	//private ConnectionFactory connectionFactory;
	private final RabbitTemplate rabbitTemplate;
	
	/*@Autowired
	public CustomerSOSController(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}*/
	
	@Autowired
	public CustomerSOSController(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Autowired
	CustomerSOSRepository custSOSRepository;
	
	@RabbitListener(queues="customer-queue")
	public void receiveCustomerDetails(Customer_SOS customerSOS) {
		
		System.out.println("Receiving from customer queue");
		//System.out.println("Cust SOS == "+customerSOS);
		
		//SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		//factory.setConnectionFactory(this.connectionFactory);
		//factory.setMessageConverter(new Jackson2JsonMessageConverter());
		//rabbitTemplate.setConnectionFactory(this.connectionFactory);
		//rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		//System.out.println("Cust SOS ID == "+customerSOS.getCustId());
		
		custSOSRepository.save(customerSOS);
		
	}
	
	/*@Bean
	public Queue queue() {
		return new Queue("customer-queue",false);
		
	}*/
	
	

}
