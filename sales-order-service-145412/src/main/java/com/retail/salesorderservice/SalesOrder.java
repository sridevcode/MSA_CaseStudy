package com.retail.salesorderservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SalesOrder {
	
	@Id
	@Column(name="order_Id")
	@GeneratedValue
	private Long salesOrderId;
	@Column(name="order_date")
	private Date OrderDate;
	@Column(name="cust_id")
	private Long custId;
	@Column(name="order_desc")
	private String OrderDesc;
	@Column(name="total_price")
	private float totalPrice;
	
	public SalesOrder(Long salesOrderId, Date orderDate, Long custId, String orderDesc, float totalPrice) {
		super();
		this.salesOrderId = salesOrderId;
		OrderDate = orderDate;
		this.custId = custId;
		OrderDesc = orderDesc;
		this.totalPrice = totalPrice;
	}
	
	public SalesOrder() {
		
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getOrderDesc() {
		return OrderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		OrderDesc = orderDesc;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
}
