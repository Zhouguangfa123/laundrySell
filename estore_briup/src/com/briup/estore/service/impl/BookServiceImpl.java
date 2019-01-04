package com.briup.estore.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.common.exception.BookServiceException;
import com.briup.estore.common.util.ConnectionFactoryUtil;
import com.briup.estore.dao.BookDaoImpl;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.service.IBookService;

public class BookServiceImpl implements IBookService {
	private Connection conn = ConnectionFactoryUtil.getConnection();
	private IBookDao bookDao = new BookDaoImpl(conn);
	
	@Override
	public List<Category> findCategoryList() {
		List<Category> categorys = null;
		try {
			categorys = bookDao.findAllCategory();
		} catch (BookServiceException e) {
			e.printStackTrace();
		}
		return categorys;
	}

	@Override
	public List<Book> findNewBooks(int num) throws BookServiceException {
		return bookDao.findNewBooks(num);
	}

	@Override
	public Book findBookByID(int bookId) throws BookServiceException {
		return bookDao.findBookById(bookId);
	}

	@Override
	public List<Book> findAllBooks() throws BookServiceException {
		return bookDao.findAllBooks();
	}

	@Override
	public List<Book> findBookByCategoryId(int CategoryId,int mark) throws BookServiceException {
		List<Book> books = null;
		if(mark==1){
			return bookDao.findBooksByCategoryOne(CategoryId);
		}else{
			return bookDao.findBooksByCategoryTwo(CategoryId);
		}
	}

	@Override
	public Category findCategoryById(int CategoryId) throws BookServiceException {
		
		return bookDao.findCategoryById(CategoryId);
	}

}
