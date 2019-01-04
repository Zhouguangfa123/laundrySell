package com.briup.estore.web.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.common.exception.CustomerServiceException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class ToOrderdetail
 */
@WebServlet("/user/toOrderDetail.do")
public class ToOrderdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOrderdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderFormId = Integer.parseInt(request.getParameter("orderFormId"));
		//根据订单编号查找订单项
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			//查找订单，包括订单项
			OrderForm orderForm = customerService.findOrderFormById(orderFormId);
			request.setAttribute("orderForm", orderForm);
		} catch (CustomerServiceException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("../orderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
