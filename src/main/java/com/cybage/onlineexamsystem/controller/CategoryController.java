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

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.model.Category;
import com.cybage.onlineexamsystem.service.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@RestController
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	/**
	 * @param category
	 */
	@PostMapping("/category/add")
	private void insertCategory(@RequestBody Category category) {
		//THIS IS JUST FOR A TRIAL, IN REAL SCENARIO WE MUST BRING DATA IN
		// JSON FORMAT AND PARSE IT.
		categoryServiceImpl.insertCategory(category);
	}

	/**
	 * @return all categories
	 */
	@GetMapping("/category/all")
	private List getAllCategories() {

		return categoryServiceImpl.getAllCategories();
	}

	/**
	 * @param id Category Id to be found
	 * @return Category Name related to the id
	 */
	@GetMapping("/category/{id}")
	private String getCategory(
			@PathVariable int id) throws CategoryNotFoundException {
		return categoryServiceImpl.getCategoryById(id);
	}

}
