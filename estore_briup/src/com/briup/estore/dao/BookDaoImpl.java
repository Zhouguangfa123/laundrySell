package com.briup.estore.dao;

import java.sql.Connection;
import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.common.exception.BookServiceException;

public class BookDaoImpl implements IBookDao {
	private Connection conn;

	public BookDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Category> findAllCategory() throws BookServiceException {
		
		
		
		return null;
	}
	
	@Override
	public List<Category> findSubCategorys(int parentId) throws BookServiceException {
		
		return null;
	}

	@Override
	public Category findCategoryById(int categoryId) throws BookServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAllBooks() throws BookServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBooksByCategoryOne(int categoryId) throws BookServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBooksByCategoryTwo(int categoryId) throws BookServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findNewBooks(int num) throws BookServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(int bookId) throws BookServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
