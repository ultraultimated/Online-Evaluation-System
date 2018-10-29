/*
 * CategoryService
 *
 * Version information
 *
<<<<<<< HEAD
 * 10/29/2018
=======
 * 10/26/2018
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryService
 * Brief description of contents of file.
 * <p>
 * Long description
<<<<<<< HEAD
 * @date 10/29/2018
 */
package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.model.Category;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author {neelp}
 */
public interface CategoryService {
	/**
	 * @param Category Category object to insert in the database
	 */
	public void insertCategory(Category Category);

	/**
	 * @return List of all categoreis in table category.
	 */
	public List<Category> getAllCategories();

	/**
	 * @param id the id to find category Name
	 * @return category name for a particular ID.
	 */
	public String getCategoryById(int id) throws EntityNotFoundException;

}


