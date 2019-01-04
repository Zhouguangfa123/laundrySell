package com.briup.estore.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderForm {
	private Integer orderFormId;
	private Double cost;
	private Date orderDate;
	private ShipAddress shipAddress;
	private Customer customer;
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	
	public OrderForm() {
		super();
	}
	public OrderForm(Double cost, Date orderDate, ShipAddress shipAddress, Customer customer) {
		this.cost = cost;
		this.orderDate = orderDate;
		this.shipAddress = shipAddress;
		this.customer = customer;
	}
	public Integer getOrderFormId() {
		return orderFormId;
	}
	public void setOrderFormId(Integer orderFormId) {
		this.orderFormId = orderFormId;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public ShipAddress getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(ShipAddress shipAddress) {
		this.shipAddress = shipAddress;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	} 
}
