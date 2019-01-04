package com.briup.estore.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车
 * */
public class ShopCar {
	//保存购物车中的订单项
	private Map<Integer, OrderLine> car = new HashMap<Integer, OrderLine>();
	
	/**
	 * 添加购物车:购物车中已有该书，修改数量，还没有，添加对应订单项
	 * @param Book book:要添加的书籍， int num：要添加书籍的数量
	 * */
	public void add(Book book,int num){
		if(car.containsKey(book.getBookId())){
			OrderLine orderLine = car.get(book.getBookId());
			int booknum = orderLine.getNum()+num;
			orderLine.setNum(booknum);
		}else{
			OrderLine orderLine = new OrderLine();
			orderLine.setBook(book);
			orderLine.setNum(num);
			car.put(book.getBookId(), orderLine);
		}
		
	}
	/**
	 * 修改购物车
	 * */
	public void update(int bookId,int num){
		OrderLine orderLine = car.get(bookId);
		if(num!=0){
			orderLine.setNum(num);
			car.put(bookId, orderLine);
		}else{
			car.remove(orderLine);
		}
	}
	/**
	 * 获取所有订单项
	 * */
	public Collection<OrderLine> getOrderLines(){
		return car.values();
	}
	/**
	 * 获取购物车总价
	 * */
	public Double getTotal(){
		Double total = 0.0;
		if(car.size()>0){
			Collection<OrderLine> lines = getOrderLines();
			for(OrderLine line : lines){
				total+=line.getCost();
			}
		}
		return total;
	}
	/**
	 * 返回购物车中商品种类数量
	 * */
	public int getNum(){
		Collection<OrderLine> lines = car.values();
		int num = 0;
		for(OrderLine line : lines){
			num+=line.getNum();
		}
		return num;
	}
	/**
	 * 清空购物车
	 * */
	public void clear(){
		car.clear();
	}
}
