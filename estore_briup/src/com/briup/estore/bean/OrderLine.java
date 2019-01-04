package com.briup.estore.bean;
/**
 * 订单项
 * */
public class OrderLine {
	private Integer orderLineId;
	private Integer num;
	private Double cost;
	private Book book;
	private OrderForm orderForm;
	
	
	public OrderLine() {
		super();
	}
	public OrderLine(Integer num, Double cost, Book book) {
		super();
		this.num = num;
		this.cost = cost;
		this.book = book;
	}
	public Integer getOrderLineId() {
		return orderLineId;
	}
	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getCost() {
		if(book!=null){
			cost = book.getPrice()*num;
		}
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	
}
