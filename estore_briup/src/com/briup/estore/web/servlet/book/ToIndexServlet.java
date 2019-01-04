package com.briup.estore.web.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.common.exception.BookServiceException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

/**
 * Servlet implementation class ToIndexServlet
 */
@WebServlet("/toIndex.do")
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//进入首页，首先查找所有的分类以及所有的书
		IBookService bookService = new BookServiceImpl();
		try {
			//找到所有一级的书籍分类，其对象中包含子级分类
			List<Category> categoryList = bookService.findCategoryList();
			//通过请求把分类信息发送到页面做展示
			request.setAttribute("categoryList", categoryList);
			System.out.println("找到所有书籍分类:"+categoryList.size()+""+categoryList);
			
			//查找最新出的三本书，新书
			List<Book> newBooks = bookService.findNewBooks(3);
			request.setAttribute("newBooks", newBooks);
			System.out.println("找到新出版的三本书:"+newBooks.size()+""+newBooks);
			
			//查出所有的书
			List<Book> findAllBooks = bookService.findAllBooks();
			request.setAttribute("findAllBooks", findAllBooks);
			System.out.println("所有图书:"+findAllBooks);
			
		} catch (BookServiceException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/esindex.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
