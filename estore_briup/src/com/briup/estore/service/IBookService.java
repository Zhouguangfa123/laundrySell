package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.common.exception.BookServiceException;

public interface IBookService {
	/**
	 * 查找所有一级分类及一级分类下的所有二级分类
	 * @return List:数据类型的集合
	 * */
	List<Category> findCategoryList() throws BookServiceException;
	/**
	 * 查找二级分类
	 * */
	Category findCategoryById(int CategoryId) throws BookServiceException;
	/**
	 * 查找最近出版的n本书
	 * */
	List<Book> findNewBooks(int num) throws BookServiceException;
	/**
	 * 按照ID查找一本书
	 * */
	Book findBookByID(int bookId) throws BookServiceException;
	/**
	 * 查找所有图书
	 * */
	List<Book> findAllBooks() throws BookServiceException;
	/**
	 * 根据类型ID查找图书
	 * */
	List<Book> findBookByCategoryId(int CategoryId,int mark) throws BookServiceException;
}
