package com.briup.estore.web.servlet.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.common.exception.BookServiceException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

@WebServlet("/viewBook.do")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBookService bookService = new BookServiceImpl();
		String bookId = request.getParameter("bookId");
		try {
			Book book = bookService.findBookByID(Integer.parseInt(bookId));
			System.out.println("查找到的书:"+book);
			request.setAttribute("viewbook", book);
		} catch(BookServiceException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/viewBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
