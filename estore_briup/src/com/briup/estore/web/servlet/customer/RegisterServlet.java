package com.briup.estore.web.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerServiceException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zipcode = request.getParameter("zipCode");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		//封装成customer对象
		Customer customer = new Customer(name, password, zipcode, address, telephone, email);
		//注册用户
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.register(customer);
		} catch (CustomerServiceException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
