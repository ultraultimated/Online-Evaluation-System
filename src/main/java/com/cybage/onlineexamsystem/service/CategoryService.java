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
 * <p>
 * Long description
 * @date 10/26/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.Category;
import com.cybage.onlineexamsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * @return instance of category repository.
	 */
	public CategoryRepository getCategoryRepository () {
		return categoryRepository;
	}

	/**
	 * @param categoryRepository repository object to set
	 */
	public void setCategoryRepository (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	/**
	 * @param Category object with values to save in database
	 */
	public void insertCategory (Category Category)
	{
		categoryRepository.save(Category);
	}

	public List<Category> getAllCategories ()
	{
		Iterable<Category> tblCategories = categoryRepository.findAll ();
		ArrayList<Category> listCategories = new ArrayList<> ();
		for ( Category category : tblCategories ) {
			listCategories.add (category);
			System.out.println ("category " + category);
		}
		System.out.print (listCategories);
		return listCategories;
	}
}
