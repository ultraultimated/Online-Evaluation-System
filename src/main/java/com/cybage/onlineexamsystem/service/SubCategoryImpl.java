/*
 * SubCategoryImpl
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file SubCategoryImpl
 * Brief description of contents of file.
 * Long description
 * @date 10/29/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Example class provides ...

 @author {neelp}
 @version
 */
@Service
public class SubCategoryImpl implements SubCategoryService
{
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Override
	public void insertSubCategory(SubCategory subCategory)
	{

	}

	@Override
	public SubCategory getAllSubcategories() {
		return null;
	}

	@Override
	public SubCategory getSubcategoryByCategoryId(int id) {
		return null;
	}
}
