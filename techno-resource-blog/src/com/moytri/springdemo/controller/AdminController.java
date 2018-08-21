package com.moytri.springdemo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.moytri.springdemo.entity.Category;
import com.moytri.springdemo.service.ICategoryService;
import com.moytri.springdemo.utility.WebResponse;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/createCategory")
	public ModelAndView createCategory(Model model ) {
		
		List<Category> categories = categoryService.getAllCategories();
		
		model.addAttribute("category", new Category());
		
		Gson gson = new Gson();
	    String categoriesJson = gson.toJson(categories);
			
		return new ModelAndView("category/create-categories", "categoriesJson", categoriesJson);

	}
	
	@PostMapping("/saveCategory")
	public ModelAndView saveCategory(HttpServletRequest request) {
		
		Map<String,String[]> map = request.getParameterMap();
		
		//save the category using service		
		WebResponse response = categoryService.addCategory(map);
		
		if(response.getStatus().equals("error")) {
			return new ModelAndView("redirect:/admin/category/createCategory");
		}
		
		return new ModelAndView("category/show-category");
		
	}

}
