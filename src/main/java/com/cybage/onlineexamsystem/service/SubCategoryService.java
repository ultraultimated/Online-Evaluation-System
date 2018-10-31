/*
 * SubCategoryService
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file SubCategoryService
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/29/2018
 */
package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.model.SubCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Example interface provides ...
 *
 * @author {neelp}
 */
@Service
public interface SubCategoryService {
	/**
	 * @param subCategory object to be added
	 */
	public void insertSubCategory(SubCategory subCategory);

	/**
	 * @return all subcategories
	 */
	public List<SubCategory> getAllSubcategories();

	/**
	 * @param categoryId category id to find subcategories
	 * @return Specific subcategories of given category ID
	 */
	public List<SubCategory> getSubcategoryByCategoryId(int categoryId) throws SubCategoryNotFoundException;

	/**
	 *
	 * @param subCategoryId Id to be searched
	 * @return Subcategory object of goven ID
	 */
	public SubCategory getSubCategoryBySubCategoryId(int subCategoryId) throws SubCategoryNotFoundException;


}
