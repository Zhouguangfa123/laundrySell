package com.briup.estore.web.servlet.order;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShipAddress;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/user/confirm.do")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICustomerService customerService = new CustomerServiceImpl();
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		ShopCar shopCar = (ShopCar) request.getSession().getAttribute("shopCar");
		ShipAddress shipA = null;
		try {
			String shipAddId = request.getParameter("shipAddId");
			if(shipAddId!=null){
				//选择收货地址，按照id查找收货地址
					shipA = customerService.findShipAddressById(Integer.parseInt(shipAddId));
					System.out.println("找到收货地址"+shipA.getReceiveName());
			}else{
				//添加新地址
				String receiveName = request.getParameter("receiveName");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				shipA = new ShipAddress(receiveName, address, phone, customer);
				customerService.saveShipAddress(shipA);
				System.out.println("保存新地址"+shipA.getReceiveName());
			}
			//保存订单与订单项，清空购物车
			OrderForm orderForm = new OrderForm();
			orderForm.setCustomer(customer);
			orderForm.setCost(shopCar.getTotal());
			orderForm.setOrderDate(new Date());
			orderForm.setShipAddress(shipA);
			for(OrderLine line :shopCar.getOrderLines()){
				orderForm.getOrderLines().add(line);
			}
			customerService.saveOrder(orderForm);
			shopCar.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("toOrderList.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
