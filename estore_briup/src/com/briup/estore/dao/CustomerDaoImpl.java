package com.briup.estore.dao;

import java.sql.Connection;
import java.util.List;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShipAddress;

public class CustomerDaoImpl implements ICustomerDao {
	private Connection conn;

	public CustomerDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	@Override
	public Customer findCustomerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShipAddress> findShipAddress(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipAddress findShipAddressById(int shipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveShipAddress(ShipAddress shipAddress) {
		// TODO Auto-generated method stub

	}
	@Override
	public void saveOrderForm(OrderForm orderForm) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveOrderLine(OrderLine orderLine) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<OrderForm> findAllOrderForm(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderLine> findOrderLinesByOId(int orderFormId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public OrderForm findOrderFormById(int orderFormId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteOrderForm(int orderFormId) {
		// TODO Auto-generated method stub
		
	}

}
