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

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The SubcategoryService class provides CRUD operations for Subcategory table
 *
 * @author {neelp}
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	/**
	 * @param subCategory object to be added
	 */
	@Override
	public void insertSubCategory(SubCategory subCategory)
	{
		subCategoryRepository.save(subCategory);
	}

	/**
	 * @return list of all subcategories
	 */
	@Override
	public List<SubCategory> getAllSubcategories() {

		return subCategoryRepository.findAll();
	}

	/**
	 * @param categoryId category id to find subcategories
	 * @return SubCategories of given ID
	 */
	@Override
	public List<SubCategory> getSubcategoryByCategoryId(int categoryId) throws SubCategoryNotFoundException
	{
		if( (subCategoryRepository.findAllByCategoryId(categoryId)).size() == 0 ) {
			return subCategoryRepository.findAllByCategoryId(categoryId);
		} else {
			throw new SubCategoryNotFoundException();
		}
	}

	/**
	 * @param subCategoryId Id to be searched
	 * @return Subcategory Object of ID found
	 */

	@Override
	public SubCategory getSubCategoryBySubCategoryId(int subCategoryId) throws SubCategoryNotFoundException {
		Optional<SubCategory> optional =
				subCategoryRepository.findById(subCategoryId);
		if( optional.isPresent() ) {
			return optional.get();
		} else {
			throw new SubCategoryNotFoundException();
		}
	}

}
