package com.briup.estore.web.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.common.exception.CustomerServiceException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath());
		System.out.println(request.getServletContext());
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		 
		ICustomerService cs = new CustomerServiceImpl();
		try {
			Customer customer = cs.login(name, password);
			System.out.println("登录成功");
			//登录成功，把用户放到session中，并给此用户绑定一个购物车
			request.getSession().setAttribute("customer", customer);
			request.getSession().setAttribute("shopCar", new ShopCar());
		} catch (CustomerServiceException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("toIndex.do").forward(request, response);;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
