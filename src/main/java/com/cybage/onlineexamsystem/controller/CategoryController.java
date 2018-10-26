/*
 * CategoryController
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryController
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/26/2018
 */


package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.model.Category;
import com.cybage.onlineexamsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The Example class provides ...

 @author {neelp}
 @version
 */
@RestController
public class CategoryController
{
	@Autowired
	private CategoryService categoryService;

	/**
	 *
	 * @return  categoryService Object.
	 */
	public CategoryService getCategoryService () {
		return categoryService;
	}

	/**
	 *
	 * @param categoryService setting the category service object to do CRUD operations
	 */
	public void setCategoryService (CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 *
	 * @param category
	 */
	@PostMapping("/insert/category")
	private void insertCategory(@RequestBody Category category)
	{
		//THIS IS JUST FOR A TRIAL, IN REAL SCENARIO WE MUST BRING DATA IN JSON FORMAT AND PARSE IT.
		categoryService.insertCategory (category);
	}
	@GetMapping("/all")
	private List getAllCategories(){
		List<Category> tblCategories = categoryService.getAllCategories ();
		return tblCategories;
	}
}
