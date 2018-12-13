package com.retail.customerservice;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Component
//@EnableHystrix
public class CustomerController {

	private final RabbitTemplate rabbitTemplate;
	//private final Customer customer;
	
	@Autowired
	CustomerRepository custRepository;
	
	@Autowired
	Environment environment;
	
	
	
	public CustomerController(RabbitTemplate rabbitTemplate) {
		//this.customer = customer;
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomereDetails(@PathVariable Long id) {
		
		Optional<Customer> custDetails = custRepository.findById(id);
		
		
		//return new Customer(100L, "sammywilson@gmail.com","Sammy","Wilson");
		return custDetails;
	}
	
	@GetMapping("/customers")
	public List getAllCustomers() {
		
		List<Customer> custList = custRepository.findAll();
		
		return custList;
	}
	
	@RequestMapping(value="/customer",method=RequestMethod.POST)
	
	public void insertCustomerData(@RequestBody Customer customer) {
		
		custRepository.save(customer);
		//rabbitTemplate.setExchange("customer-queue");
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.convertAndSend("customer-queue",customer);
	
		
}
	/*@GetMapping("/customer/fault-tolerance")
	@HystrixCommand(fallbackMethod="getFallBackCustomereDetails")
	public Optional<Customer> getCustomerDetailsFaultTol() {
	throw new RuntimeException ("some issue");
	}
	
	public Customer getFallBackCustomereDetails() {
		return new Customer(10000L,"Sample email","First name","Second Name");
	}*/
             
}