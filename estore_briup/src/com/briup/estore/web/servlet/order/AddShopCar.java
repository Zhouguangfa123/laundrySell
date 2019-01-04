package com.briup.estore.web.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.common.exception.BookServiceException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

/**
 * Servlet implementation class AddShopCar
 */
@WebServlet("/user/addShopCar.do")
public class AddShopCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session中保存的该用户的购物车
		ShopCar shopCar =  (ShopCar) request.getSession().getAttribute("shopCar");
		//获取页面传入的参数 
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int num = Integer.parseInt(request.getParameter("num"));
		//通过bookId查找对应的书
		IBookService bookService = new BookServiceImpl();
		try {
			Book findBookByID = bookService.findBookByID(bookId);
			shopCar.add(findBookByID, num);
			System.out.println("添加购物车");
		} catch (BookServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/shopCar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
