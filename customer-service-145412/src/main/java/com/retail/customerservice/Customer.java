package com.retail.customerservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    
	@Id
	@Column(name="cust_id")
	private Long custId;
	private String email;
	
	@Column(name="first_Name")
	private String firstName;
	
	@Column(name="last_Name")
	private String lastName;
	
		
	public Customer(Long custId, String email, String firstName, String lastName) {
		super();
		this.custId = custId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Customer() {
}
	
	
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
