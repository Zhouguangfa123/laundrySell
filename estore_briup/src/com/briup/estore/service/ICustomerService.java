package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShipAddress;
import com.briup.estore.common.exception.CustomerServiceException;

/**
 * 与customer相关的业务逻辑处理类
 * */
public interface ICustomerService {
	/**
	 * 登录
	 * */
	 Customer login(String name,String password) throws CustomerServiceException;
	 /**
	 * 注册
	 * */
	 void register(Customer customer) throws CustomerServiceException;
	 /**
	 * 根据用户ID查找收货地址列表
	 * */
	 List<ShipAddress> findShipAddress(int customerId) throws CustomerServiceException;
	 /**
	 * 根据收货地址ID查找收货地址
	 * */
	 ShipAddress findShipAddressById(int shipId) throws CustomerServiceException;
	 /**
	 * 保存收货地址
	 * */
	 void saveShipAddress(ShipAddress shipAddress) throws CustomerServiceException;
	 /**
	 * 保存订单，订单入库，包括订单中的订单项的集合 也要入库
	 * */
	 void saveOrder(OrderForm orderForm) throws CustomerServiceException;
	 /**
	 * 根据顾客ID查找所有订单
	 * */
	 List<OrderForm> findAllOrderForm(int customerId) throws CustomerServiceException;
	 /**
	 * 根据订单ID查找所有订单
	 * */
	 OrderForm findOrderFormById(int orderFormId) throws CustomerServiceException;
	 /**
	 * 根据订单ID删除订单
	 * */
	 void deleteOrderForm(int orderFormId) throws CustomerServiceException;
}
