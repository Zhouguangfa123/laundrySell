package com.briup.estore.bean;
/**
 * 收货地址
 * @author liuzx
 * */
public class ShipAddress {
	private Integer saId;
	private String receiveName;
	private String address;
	private String phone;
	private Customer customer;
	
	
	public ShipAddress() {
	}
	public ShipAddress(String receiveName, String address, String phone, Customer customer) {
		this.receiveName = receiveName;
		this.address = address;
		this.phone = phone;
		this.customer = customer;
	}
	public Integer getSaId() {
		return saId;
	}
	public void setSaId(Integer saId) {
		this.saId = saId;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
