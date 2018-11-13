/*
 * SubCategoryController
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file SubCategoryController
 * Brief description of contents of file.
 * Long description
 * @date 10/29/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.service.SubCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

	@Autowired
	private SubCategoryServiceImpl subCategoryServiceImpl;

	/**
	 * @param subCategory Subcategory object to be inserted in database.
	 */
	@PostMapping("/insert")
	private void insertSubCategory(@RequestBody SubCategory subCategory) {
		subCategoryServiceImpl.insertSubCategory(subCategory);
	}

	/**
	 * @param categoryId categoryId to be found in database
	 * @return list of all subcategories of given category ID.
	 */
	@GetMapping("/category/id/{categoryId}")
	private List getSubcategoryByCategoryId(
			@PathVariable int categoryId) throws CategoryNotFoundException {

		return subCategoryServiceImpl.getSubcategoryByCategoryId(categoryId);
	}

	/**
	 * @param subCategoryId to be found
	 * @return SubCategoryName related to the id
	 * @throws SubCategoryNotFoundException
	 */
	@GetMapping("/id/{subCategoryId}")
	private SubCategory getSubCategeryById(
			@PathVariable
					int subCategoryId) throws SubCategoryNotFoundException {
		return subCategoryServiceImpl.getSubCategoryById(subCategoryId);
	}

	/**
	 * @return List of all subcatgories present
	 */
	@GetMapping("/all")
	private List getAllSubCategories() {
		return subCategoryServiceImpl.getAllSubcategories();
	}

}
