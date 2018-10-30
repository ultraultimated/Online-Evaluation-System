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

import com.cybage.onlineexamsystem.model.Option;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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
	public void insertSubCategory(SubCategory subCategory) {
		subCategoryRepository.save(subCategory);
	}

	/**
	 * @return list of all subcategories
	 */
	@Override
	public List<SubCategory> getAllSubcategories() {
		Iterable<SubCategory> subCategories = subCategoryRepository.findAll();
		if (Iterables.size(subCategories) == 0) {
			throw new EntityNotFoundException("No Subcategories exist");
		} else {
			ArrayList<SubCategory> listSubCategories = new ArrayList<>();
			for (SubCategory subCategory : subCategories) {
				listSubCategories.add(subCategory);
			}
			return listSubCategories;
		}
	}

	/**
	 * @param id category id to find subcategories
	 * @return SubCategories of given ID
	 */
	@Override
	public List<SubCategory> getSubcategoryByCategoryId(int id) {
		Iterable<SubCategory> subCategories = subCategoryRepository
				.findAllByCategoryId(id);
		if (Iterables.size(subCategories) == 0) {
			throw new EntityNotFoundException("SubCategrories with given ID " +
			                                  "does not exist");
		} else {


			ArrayList<SubCategory> listSubCategories = new ArrayList<>();
			for (SubCategory subCategory : subCategories) {
				listSubCategories.add(subCategory);
			}

			return listSubCategories;
		}
	}

	/**
	 * @param subCategoryId Id to be searched
	 * @return Subcategory Object of ID found
	 */
	@Override
	public SubCategory getSubCategoryBySubCategoryId(int subCategoryId) {
		Optional<SubCategory> optional = subCategoryRepository.findById
				(subCategoryId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EntityNotFoundException("Subcategory with specified ID" +
			                                  " " +
			                                  "does not exist");
		}
	}

}
