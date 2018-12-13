package com.retail.salesorderservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LineItem {
	
	@Id
	@Column(name="lineitem_Id")
	@GeneratedValue
	private Long lineItemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_quantity")
	private int itemQuantity;
	@Column(name="order_id")
	private Long orderId;
	
	private int port;
	
	
	public LineItem(Long lineItemId, String itemName, int itemQuantity, Long orderId,int port) {
		super();
		this.lineItemId = lineItemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
		this.port = port;
	}
	
	public LineItem() {
		
	}

	public Long getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
	

}
