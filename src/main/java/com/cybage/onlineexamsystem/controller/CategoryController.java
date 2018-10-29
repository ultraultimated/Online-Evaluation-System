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
import com.cybage.onlineexamsystem.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	private CategoryServiceImpl categoryServiceImpl;

	/**
	 *
	 * @return  categoryService Object.
	 */
	public CategoryServiceImpl getCategoryServiceImpl () {
		return categoryServiceImpl;
	}

	/**
	 *
	 * @param categoryServiceImpl setting the category service object to do CRUD operations
	 */
	public void setCategoryServiceImpl (CategoryServiceImpl categoryServiceImpl) {
		this.categoryServiceImpl = categoryServiceImpl;
	}

	/**
	 *
	 * @param category
	 */
	@PostMapping("/insert/category")
	private void insertCategory(@RequestBody Category category)
	{
		//THIS IS JUST FOR A TRIAL, IN REAL SCENARIO WE MUST BRING DATA IN JSON FORMAT AND PARSE IT.
		categoryServiceImpl.insertCategory (category);
	}

	/**
	 *
	 * @return all categories
	 */
	@GetMapping("/all")
	private List getAllCategories(){
		List<Category> tblCategories = categoryServiceImpl.getAllCategories ();
		return tblCategories;
	}

	/**
	 *
	 * @param id Category Id to be found
	 * @return Category Name relaetd to the id
	 */
	@GetMapping("/category/{id}")
	private String getCategory(@PathVariable int id)
	{
		return categoryServiceImpl.getCategoryById(id);
	}
}
