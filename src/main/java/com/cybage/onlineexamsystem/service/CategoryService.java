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
	 *
	 * @param id the id to find category Name
	 * @return category name for a particular ID.
	 */
	public String getCategoryById(int id) throws EntityNotFoundException;

=======
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
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788
}
