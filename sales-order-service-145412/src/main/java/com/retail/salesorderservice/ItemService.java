package com.retail.salesorderservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="item-service")
@RibbonClient(name="item-service")
public interface ItemService {
	
	@GetMapping("/items/{itemName}")
	public LineItem getItem(@PathVariable("itemName") String itemName);

}
