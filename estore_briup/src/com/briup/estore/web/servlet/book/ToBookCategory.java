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
 * 跳转到某个分类下
 * */
@WebServlet("/toBookCategory.do")
public class ToBookCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToBookCategory() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookService bookService = new BookServiceImpl();
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int mark = Integer.parseInt(request.getParameter("mark"));
		try {
			List<Book> booksByCate = bookService.findBookByCategoryId(categoryId,mark);
			request.setAttribute("books", booksByCate);
			//查找对应的分类对象
			Category category = bookService.findCategoryById(categoryId);
			request.setAttribute("category", category);
		} catch (BookServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
