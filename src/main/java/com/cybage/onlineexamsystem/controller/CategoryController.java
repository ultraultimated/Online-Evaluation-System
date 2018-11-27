/*
 * CategoryController
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryController
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/26/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.CategoryNotFoundException;
import com.cybage.onlineexamsystem.model.Category;
import com.cybage.onlineexamsystem.model.dto.CategoryDTO;
import com.cybage.onlineexamsystem.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CategoryService categoryService;

    /**
     * @param category
     */
    @PostMapping("/insert")
    private void insertCategory(@RequestBody Category category) {
        // THIS IS JUST FOR A TRIAL, IN REAL SCENARIO WE MUST BRING DATA IN
        // JSON FORMAT AND PARSE IT.
        categoryService.insertCategory(category);
    }

    /**
     * @return all categories
     */
    @GetMapping("/all")
    private List getAllCategories() {

        return categoryService.getAllCategories();
    }

    /**
     * @param id Category Id to be found
     * @return Category Name related to the id
     */
    @GetMapping("/id/{id}")
    private Category getCategory(@PathVariable int id) throws CategoryNotFoundException {
        return categoryService.getCategoryById(id);
    }

    /**
     * @param categoryId
     * @return Only categoryId and Name with subcategoryId and Name for given categoryId
     * @throws CategoryNotFoundException
     */
    @GetMapping("/subcategory/id/{categoryId}")
    private CategoryDTO getCategoryOnlyById(@PathVariable int categoryId) throws CategoryNotFoundException {

        Type category = new TypeToken<CategoryDTO>() {
        }.getType();
        return modelMapper.map(categoryService.getCategoryById(categoryId), category);
    }

    /**
     * @return all categoryId and Name with subcategoryId and Name
     */
    @GetMapping("/subcategory/all")
    private List<CategoryDTO> getOnlyCategory() {

        Type categoryListType = new TypeToken<List<CategoryDTO>>() {
        }.getType();
        return modelMapper.map(categoryService.getAllCategories(), categoryListType);
    }

}