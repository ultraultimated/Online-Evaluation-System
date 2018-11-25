/*
 * SubCategoryController
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file SubCategoryController
 * Brief description of contents of file.
 * Long description
 * @date 10/29/2018
 */

package com.cybage.onlineexamsystem.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.model.dto.SubCategoryDTO;
import com.cybage.onlineexamsystem.service.SubCategoryService;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subcategory")
public class SubCategoryController
{

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param subCategory
     *            Subcategory object to be inserted in database.
     */
    @PostMapping("/insert")
    private void insertSubCategory(@RequestBody SubCategory subCategory)
    {
	subCategoryService.insertSubCategory(subCategory);
    }

    /**
     * @param categoryId
     *            categoryId to be found in database
     * @return list of all subcategories of given category ID.
     */
    @GetMapping("/category/id/{categoryId}")
    private List<SubCategoryDTO> getSubcategoryByCategoryId(@PathVariable int categoryId)
	    throws CategoryNotFoundException
    {
	Type subCategoryListType = new TypeToken<List<SubCategoryDTO>>()
	{
	}.getType();
	return modelMapper.map(subCategoryService.getSubcategoryByCategoryId(categoryId), subCategoryListType);
	// return subCategoryService.getSubcategoryByCategoryId(categoryId);
    }

    /**
     * @param subCategoryId
     *            to be found
     * @return SubCategoryName related to the id
     * @throws SubCategoryNotFoundException
     */
    @GetMapping("/id/{subCategoryId}")
    private SubCategory getSubCategeryById(@PathVariable int subCategoryId) throws SubCategoryNotFoundException
    {
	return subCategoryService.getSubCategoryById(subCategoryId);
    }

    /**
     * @return List of all subcatgories present
     */
    @GetMapping("/all")
    private List getAllSubCategories()
    {
	return subCategoryService.getAllSubcategories();
    }

}
