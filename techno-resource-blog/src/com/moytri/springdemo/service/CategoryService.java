package com.moytri.springdemo.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moytri.springdemo.dao.ICategoryDAO;
import com.moytri.springdemo.entity.Category;
import com.moytri.springdemo.utility.WebResponse;

@Service
@Transactional
public class CategoryService implements ICategoryService{

	@Autowired
	private ICategoryDAO categoryDAO;
	

	@Override
	@Transactional
	public WebResponse addCategory(Map<String, String[]> map) {
	
		UUID id = null;
		
		String [] ids  = (String[]) map.get("id[]"); 
		String [] catCodes  = (String[]) map.get("category_code[]"); 
		String [] catNames  = (String[]) map.get("category_name[]");
		
		System.out.println(catCodes.length + " " + catCodes);
		for(int i = 0; i < catCodes.length; i++) {
			
			Category category = null;
			
			if(ids[i] != "") {
				category = categoryDAO.getCategoryById(UUID.fromString(ids[i]));
			}
			
			if(category == null) {
				category = new Category();
			}
			category.setCategoryCode(catCodes[i]);
			category.setCategoryName(catNames[i]);
			
			id = categoryDAO.updateCategory(category);
			
			if(id == null) {
				return new WebResponse("error", "Unsuccessful", null);
			}
		}
		
		return new WebResponse("success", "Successful", id, null);
	}
	
/*	@Transactional
	public WebResponse addCategory(Category category) {
		
		//Validation code start
	    boolean error = false;
	    WebResponse response;
	    
		if(category.getCategoryCode().isEmpty()) {
			error = true;
		}
		
		if(category.getCategoryName().isEmpty()) {
			error = true;
		}
		
		if(error) {
			return new WebResponse("error", "Unsuccessful", null);
		}
		
		UUID id = categoryDAO.addCategory(category);
		
		if(id == null) {
			return new WebResponse("error", "Unsuccessful", null);
		}
		
		return new WebResponse("success", "Successful", id, null);
	}*/

	@Override
	public void deleteCategory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UUID updateCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}


}
