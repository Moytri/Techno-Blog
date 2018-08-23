package com.moytri.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.moytri.springdemo.entity.Category;
import com.moytri.springdemo.service.ICategoryService;

@Controller
@RequestMapping("/blog")
public class HomeController {
	
	@Autowired
	ICategoryService categoryService;
	
	@RequestMapping("/loadCategories")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/home")
	public ModelAndView loadCategories(Model model) {
		
		List<Category> categories = categoryService.getAllCategories();
				
		Gson gson = new Gson();
	    String categoriesJson = gson.toJson(categories);
	    
	    System.out.println(categories);
	    
	    return new ModelAndView("home", "categories", categories);
	}

}
