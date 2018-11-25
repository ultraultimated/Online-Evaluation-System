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
import com.cybage.onlineexamsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    /**
     * @param Category object with values to save in database
     */
    @Override
    public void insertCategory(Category Category) {
        categoryRepository.save(Category);
    }

    /**
     * @return List of all categories in category table
     */
    @Override
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

//	public CategoryDTO getCategoryDTOById(int categoryId) throws CategoryNotFoundException {
//
//		Category category = new Category();
//		category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
//		ModelMapper modelMapper = new ModelMapper();
//		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
//		return categoryDTO;
//	}

//	public CategoryDTO getCategoryDTOById(int categoryId) throws CategoryNotFoundException {
//
//		Category category = new Category();
//		category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
//		ModelMapper modelMapper = new ModelMapper();
//		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
//		return categoryDTO;
//	}

}
