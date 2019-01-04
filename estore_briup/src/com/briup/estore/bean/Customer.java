package com.briup.estore.bean;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private Integer customerId;
	private String name;
	private String password;
	private String zipCode;
	private String address;
	private String telephone;
	private String email;
	private List<OrderForm> orderForms = new ArrayList<OrderForm>();
	
	public Customer() {
	}
	public Customer(String name, String password, String zipCode, String address, String telephone, String email) {
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}


	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<OrderForm> getOrderForms() {
		return orderForms;
	}
	public void setOrderForms(List<OrderForm> orderForms) {
		this.orderForms = orderForms;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", password=" + password + ", zipCode="
				+ zipCode + ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", orderForms="
				+ orderForms + "]";
	}
}
