package com.retail.salesorderservice;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesOrderController {
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@Autowired
	LineItemRepository lineItemRepository;
	
	@Autowired
	CustomerSOSRepository custSOSRepository;
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/salesorderservice/orders")
	public LineItem insertSalesOrderDetails(@RequestBody OrderRequest orderRequest) {
				
		Long custId = orderRequest.getCustId();
		//Call customer_sos tabble to validate 
		
		Optional<Customer_SOS> custSOS = custSOSRepository.findById(custId);
		
		/*ResponseEntity<SalesOrder> orderEntity = new RestTemplate().getForEntity("http://localhost:6060/customer/{custId}",SalesOrder.class,custId);
		SalesOrder salesOrder = orderEntity.getBody();*/
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setOrderDesc(orderRequest.getOrderDescription());
		salesOrder.setOrderDate(new Date());
		salesOrder.setCustId(custId);
		salesOrder.setTotalPrice(orderRequest.getTotalPrice());
		
		salesOrderRepository.save(salesOrder);
		Long orderId= salesOrder.getSalesOrderId();
		System.out.println("orderId ="+orderId);
		
		LineItem itemDetails = new LineItem();
		ItemRequest items = orderRequest.getItems();
		
		String itemName= items.getItemName();
		
		/*ResponseEntity<LineItem> itemEntity = new RestTemplate().getForEntity("http://localhost:6161/items/{itemName}",LineItem.class,itemName);
	    String   itemNameResponse = itemEntity.getBody().getItemName();*/
	    
	    LineItem lineItem = itemService.getItem(itemName);
	    String   itemNameResponse = lineItem.getItemName();
	    System.out.println("itemNameResponse ==="+itemNameResponse);
		
		itemDetails.setItemName(itemNameResponse);
		itemDetails.setItemQuantity(items.getItemQuantity());
		itemDetails.setOrderId(orderId);
		itemDetails.setPort(lineItem.getPort());
		
			
		lineItemRepository.save(itemDetails);
		
		
	    return itemDetails;
	    
	}

}
