package com.briup.estore.web.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.common.exception.CustomerServiceException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class RemoveOrderForm
 */
@WebServlet("/user/removeOrderForm.do")
public class RemoveOrderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveOrderForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderFormId = Integer.parseInt(request.getParameter("orderFormId"));
		//根据订单编号删除订单 
		ICustomerService customerService = new CustomerServiceImpl();
		try {
			customerService.deleteOrderForm(orderFormId);
		} catch (CustomerServiceException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("toOrderList.do").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
