/*
 * CategoryService
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryService
 * Brief description of contents of file.
 * Long description
 * @date 10/26/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.model.Category;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.model.dto.CategoryDTO;
import com.cybage.onlineexamsystem.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;


	/**
	 * @param Category object with values to save in database
	 */
	public void insertCategory(Category Category) {
		categoryRepository.save(Category);
	}

	/**
	 * @return List of all categories in category table
	 */
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	/**
	 * @param categoryId the categoryId to find category Name
	 * @return name of category by its ID
	 */
	@Override
	public Category getCategoryById(int categoryId) throws
			CategoryNotFoundException {

		return categoryRepository.findById(categoryId).orElseThrow
				(CategoryNotFoundException::new);
	}

}
