package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.common.exception.BookServiceException;

public interface IBookDao {
		//查找所有的分类(一级分类，需要把二级分类属性也赋值成功)
		List<Category> findAllCategory() throws BookServiceException;
		//根据一级分类ID查找所有子分类
		List<Category> findSubCategorys(int parentId) throws BookServiceException;
		//根据分类ID查找此分类
		Category findCategoryById(int categoryId) throws BookServiceException;
		//查找所有图书
		List<Book> findAllBooks() throws BookServiceException;
		//查找一级分类下的图书
		List<Book> findBooksByCategoryOne(int categoryId) throws BookServiceException;
		//查找二级分类下的图书
		List<Book> findBooksByCategoryTwo(int categoryId) throws BookServiceException;
		//按照出版时间查询，查找前3名 可以变更查找条件
		List<Book> findNewBooks(int num) throws BookServiceException;
		//按照ID查找一本书
		Book findBookById(int bookId) throws BookServiceException;
}
