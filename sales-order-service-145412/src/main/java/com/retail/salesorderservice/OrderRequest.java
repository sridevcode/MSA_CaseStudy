package com.retail.salesorderservice;

import java.util.Date;
import java.util.List;

public class OrderRequest {
	
	private String orderDescription;
    private Date orderDate;
    private Long custId;
    private ItemRequest items;
    private float totalPrice;
    
    //private String itemName;
    
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public ItemRequest getItems() {
		return items;
	}
	public void setItems(ItemRequest items) {
		this.items = items;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	/*public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}*/
    
    
    
    
}
