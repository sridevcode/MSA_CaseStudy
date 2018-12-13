package com.retail.salesorderservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer_SOS implements Serializable{
	
	
	@Id
	@Column(name="cust_sos_id")
	@GeneratedValue
	private Long id;
	
	@Column(name="cust_id")
	private Long custId;
	
	@Column(name="cust_email")
	private String email;
	
	@Column(name="cust_first_Name")
	private String firstName;
	
	@Column(name="cust_last_Name")
	private String lastName;
	
	public Customer_SOS() {}

	public Customer_SOS(Long custId, String email, String firstName, String lastName) {
		super();
		this.custId = custId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
