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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@RestController
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;

	@PostMapping("/subcategory/all")
	private void insertSubCategory(@RequestBody SubCategory subCategory) {

	}

}
