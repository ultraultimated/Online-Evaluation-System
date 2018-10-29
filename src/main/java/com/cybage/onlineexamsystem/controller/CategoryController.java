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
<<<<<<< HEAD
import com.cybage.onlineexamsystem.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import com.cybage.onlineexamsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788

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
<<<<<<< HEAD
	private CategoryServiceImpl categoryServiceImpl;
=======
	private CategoryService categoryService;
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788

	/**
	 *
	 * @return  categoryService Object.
	 */
<<<<<<< HEAD
	public CategoryServiceImpl getCategoryServiceImpl () {
		return categoryServiceImpl;
=======
	public CategoryService getCategoryService () {
		return categoryService;
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788
	}

	/**
	 *
<<<<<<< HEAD
	 * @param categoryServiceImpl setting the category service object to do CRUD operations
	 */
	public void setCategoryServiceImpl (CategoryServiceImpl categoryServiceImpl) {
		this.categoryServiceImpl = categoryServiceImpl;
=======
	 * @param categoryService setting the category service object to do CRUD operations
	 */
	public void setCategoryService (CategoryService categoryService) {
		this.categoryService = categoryService;
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788
	}

	/**
	 *
	 * @param category
	 */
	@PostMapping("/insert/category")
	private void insertCategory(@RequestBody Category category)
	{
		//THIS IS JUST FOR A TRIAL, IN REAL SCENARIO WE MUST BRING DATA IN JSON FORMAT AND PARSE IT.
<<<<<<< HEAD
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
=======
		categoryService.insertCategory (category);
	}
	@GetMapping("/all")
	private List getAllCategories(){
		List<Category> tblCategories = categoryService.getAllCategories ();
		return tblCategories;
	}
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788
}
