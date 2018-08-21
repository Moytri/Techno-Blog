package com.moytri.springdemo.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;

import com.moytri.springdemo.entity.Category;
import com.moytri.springdemo.utility.WebResponse;

public interface ICategoryService {
	
	public void deleteCategory();
	public UUID updateCategory();
	public Category getCategory();
	public List<Category> getAllCategories();
	public WebResponse addCategory(Map<String, String[]> map);
	
}
