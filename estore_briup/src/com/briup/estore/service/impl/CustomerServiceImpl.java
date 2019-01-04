package com.briup.estore.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShipAddress;
import com.briup.estore.common.exception.CustomerServiceException;
import com.briup.estore.common.util.ConnectionFactoryUtil;
import com.briup.estore.dao.BookDaoImpl;
import com.briup.estore.dao.CustomerDaoImpl;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.service.ICustomerService;

/**
 * 处理与顾客有关的业务逻辑
 * */
public class CustomerServiceImpl implements ICustomerService {
	private Connection conn = ConnectionFactoryUtil.getConnection();
	private ICustomerDao customerDao = new CustomerDaoImpl(conn);
	
	@Override
	public Customer login(String name, String password) throws CustomerServiceException {
		//首先看该用户在数据库中是否存在
		Customer findCustomer = customerDao.findCustomerByName(name);
		//用户不存在,抛异常让代码执行上一层，提示给用户
		if(findCustomer==null){
			System.out.println("1");
			CustomerServiceException e = new CustomerServiceException("该用户不存在");
			throw e;
		}
		System.out.println("2");
		//用户存在，判断密码是否正确
		if(!findCustomer.getPassword().equals(password)){
			System.out.println("3");
			throw new CustomerServiceException("用户密码错误");
		}
		System.out.println("4");
		return findCustomer;
	}

	@Override
	public void register(Customer customer) throws CustomerServiceException {
		//查看用户名是否存在
		Customer findCustomerByName = customerDao.findCustomerByName(customer.getName());
		if(findCustomerByName!=null){
			throw new CustomerServiceException("用户名已存在");
		}
		System.out.println(customer);
		customerDao.saveCustomer(customer);
		System.out.println("注册成功");
	}

	@Override
	public List<ShipAddress> findShipAddress(int customerId) throws CustomerServiceException {
		return customerDao.findShipAddress(customerId);
	}

	@Override
	public ShipAddress findShipAddressById(int shipId) throws CustomerServiceException {
		return customerDao.findShipAddressById(shipId);
	}

	@Override
	public void saveShipAddress(ShipAddress shipAddress) throws CustomerServiceException {
		customerDao.saveShipAddress(shipAddress);
	}

	@Override
	public void saveOrder(OrderForm orderForm) throws CustomerServiceException {
		customerDao.saveOrderForm(orderForm);
		for(OrderLine line : orderForm.getOrderLines()){
			customerDao.saveOrderLine(line);
		}
	}

	@Override
	public List<OrderForm> findAllOrderForm(int customerId) throws CustomerServiceException {
		
		return customerDao.findAllOrderForm(customerId);
	}

	@Override
	public OrderForm findOrderFormById(int orderFormId) throws CustomerServiceException {
		return customerDao.findOrderFormById(orderFormId);
	}

	@Override
	public void deleteOrderForm(int orderFormId) throws CustomerServiceException {
		customerDao.deleteOrderForm(orderFormId);
	}


}
