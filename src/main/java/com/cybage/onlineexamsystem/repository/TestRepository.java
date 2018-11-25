/*
 * TestRepository
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file TestRepository
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */
package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The Example interface provides ...
 *
 * @author {neelp}
 */
public interface TestRepository extends JpaRepository<Test, Integer> {

	@Query(value = "SELECT COUNT(*) FROM TBL_TEST WHERE SUBCATEGORY_ID = ?1",
			nativeQuery = true)
	long countBySubcategoryId(int subCategoryId) throws Exception;
	@Query(value = "select subcategory_id from tbl_test where test_id = ?1",
			nativeQuery = true)
	public String findTestByTestId(int testId);
}
