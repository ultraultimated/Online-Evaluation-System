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

import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.service.SubCategoryService;
import com.cybage.onlineexamsystem.utility.LoggerClass;
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
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;

	/**
	 * @param subCategory Subcategory object to be inserted in database.
	 */
	@PostMapping("/subcategory/insert")
	private void insertSubCategory(@RequestBody SubCategory subCategory)
	{

		subCategoryService.insertSubCategory(subCategory);
	}

	/**
	 * @param categoryId categoryId to be found in database
	 * @return list of all subcategories of given category ID.
	 */
	@GetMapping("/subcategory/category/{categoryId}")
	private List getSubcategoryByCategoryId(@PathVariable int categoryId)
	{

		return subCategoryService.getSubcategoryByCategoryId(categoryId);
	}

	@GetMapping("/subcategory/{subCategoryId}")
	private SubCategory getSubCategeryBySubCategoryId(
			@PathVariable int subCategoryId)
	{
		return subCategoryService.getSubCategoryBySubCategoryId(subCategoryId);
	}

	/**
	 *
	 * @return List of all subcatgories present
	 */
	@GetMapping("/subcategory/all")
	private List getAllSubCategories()
	{
		return subCategoryService.getAllSubcategories();
	}


}
