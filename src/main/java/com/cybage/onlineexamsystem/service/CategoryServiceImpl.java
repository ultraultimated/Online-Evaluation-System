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

import com.cybage.onlineexamsystem.model.Category;
import com.cybage.onlineexamsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		Iterable<Category> tblCategories = categoryRepository.findAll();
		ArrayList<Category> listCategories = new ArrayList<>();
		for( Category category : tblCategories ) {
			listCategories.add(category);
			System.out.println("category " + category);
		}
		System.out.print(listCategories);
		return listCategories;
	}

	/**
	 * @param id the id to find category Name
	 * @return name of category by its ID
	 */
	@Override
	public String getCategoryById(int id) throws EntityNotFoundException {
		Optional<Category> optional = categoryRepository.findById(id);
		if( optional.isPresent() ) {
			Category category = optional.get();
			return category.getCategoryName();
		} else {
			throw new EntityNotFoundException("Category with the specified " +
			                                  "ID" +
			                                  "is not found");
		}
	}
}
