package com.retail.itemservice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	Environment environment;
	
	@Autowired
	ItemConfiguration itemConfig;
	
	 @GetMapping("/items/{itemName}")
	 public Item getItemDetails(@PathVariable String itemName) {
		 
		 Item itemDetails = itemRepository.findByItemName(itemName);
		 
		 itemDetails.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		 System.out.println("Env port == "+environment.getProperty("local.server.port"));
		 
		 return itemDetails;
	 }
	 
	 @GetMapping("/items")
	 public List getAllItems() {
		 
		 List<Item> itemList = itemRepository.findAll();
		 return itemList;
		 
	 }
	 
	    @GetMapping("/items/fault-tolerance")
		@HystrixCommand(fallbackMethod="getFallBackCustomereDetails")
		public Item getCustomerDetailsFaultTol() {
		throw new RuntimeException ("some issue");
		}
		
		public Item getFallBackCustomereDetails() {
			//return new Item(10000L,"Sample Item","Fall back item",10.0f,0);
			return new Item(10000L,itemConfig.getItemName(),itemConfig.getItemDescription(),10.0f,0);
		}

}
