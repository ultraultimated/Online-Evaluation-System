/*
 * SubCategoryRepository
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file SubCategoryRepository
 * Brief description of contents of file.
 * Long description
 * @date 10/29/2018
 */


package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,
		Integer> {
//	List<SubCategory> findAllByCategoryId(int categoryId);
}
