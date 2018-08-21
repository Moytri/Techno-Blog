package com.moytri.springdemo.dao;

import java.util.List;
import java.util.UUID;

import com.moytri.springdemo.entity.Category;



public interface ICategoryDAO {

	public UUID addCategory(Category category);
	public void deleteCategory();
	public Category getCategoryById(UUID id);
	public List<Category> getAllCategories();
	public UUID updateCategory(Category category);	
}
