package com.briup.estore.bean;

import java.util.List;

public class Category {
	private Integer categoryId;
	private String name;
	private String descn;
	private Category parent;
	private List<Category> subCategorys;
	private List<Book> books;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public List<Category> getSubCategorys() {
		return subCategorys;
	}
	public void setSubCategorys(List<Category> subCategorys) {
		this.subCategorys = subCategorys;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		if(parent!=null){
			return "Category [categoryId=" + categoryId +", parent= "+ parent.getName()+parent.getSubCategorys().get(0).getParent().getName()+", name=" + name + "]";
		}
		return "Category [categoryId=" + categoryId +", name=" + name + subCategorys + "]"+books;
	}
}
