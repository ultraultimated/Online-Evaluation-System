/*
 * CategoryService
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryService
 * Brief description of contents of file.
 * Long description
 * @date 10/29/2018
 */
package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author {neelp}
 */
@Service
public interface CategoryService {

    /**
     * @param Category Category object to insert in the database
     */
    void insertCategory(Category Category);

    /**
     * @return List of all categories in table category.
     */
    List<Category> getAllCategories();

    /**
     * @param id the id to find category Name
     * @return category name for a particular ID.
     */
    Category getCategoryById(int id) throws CategoryNotFoundException;

}


