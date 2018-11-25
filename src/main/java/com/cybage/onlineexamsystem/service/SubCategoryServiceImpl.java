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

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.repository.CategoryRepository;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The SubcategoryService class provides CRUD operations for Subcategory table
 *
 * @author {neelp}
 */
@Component
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

        return subCategoryRepository.findAll();
    }

    /**
     * @param categoryId category id to find subcategories
     * @return SubCategories of given ID
     */
    @Override
    public List<SubCategory> getSubcategoryByCategoryId(int categoryId) throws
            CategoryNotFoundException {

        return categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new).getSubCategoryList();
    }

    /**
     * @param subCategoryId Id to be searched
     * @return Subcategory Object of ID found
     */
    @Override
    public SubCategory getSubCategoryById(int subCategoryId) throws
            SubCategoryNotFoundException {
        return subCategoryRepository.findById(subCategoryId).orElseThrow(SubCategoryNotFoundException::new);
    }

    @Override
    public String getCategoryIdBySubcategoryId(int subcategoryId) {
        return subCategoryRepository.getCategoryIdBySubcategoryId(subcategoryId);
    }

}
