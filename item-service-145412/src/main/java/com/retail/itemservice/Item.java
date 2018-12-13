package com.retail.itemservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@Column(name="item_Id")
	private Long itemId;
	
	@Column(name="item_Name")
	private String itemName;
	
	private String description;
	private float price;
	
	private int port;
	
	
	
	public Item(Long itemId, String itemName, String description, float price,int port) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.port = port;
	}
	
	
	
	public Item() {
		
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDecsription(String decsription) {
		this.description = decsription;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	

}
