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

import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.model.dto.IdMapDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * The Example interface provides ...
 *
 * @author {neelp}
 */
public interface TestRepository extends JpaRepository<Test, Integer> {

	@Query(value = "SELECT COUNT(*) FROM TBL_TEST WHERE SUBCATEGORY_ID = ?1",
			nativeQuery = true)
	long countBySubcategoryId(int subCategoryId) throws Exception;


	/**
	 * @param testId
	 * @return categoryId and subcategoryId
	 */
	@Query(value = "select tbl_category.category_id,tbl_subcategory.subcategory_id from tbl_category " +
			"inner join tbl_subcategory where tbl_category.category_id=tbl_subcategory.category_id && " +
			"subcategory_id=(select tbl_subcategory.subcategory_id from tbl_subcategory inner join tbl_test " +
			"where tbl_subcategory.subcategory_id=tbl_test.subcategory_id && test_id=?)",
			nativeQuery = true)
	IdMapDTO findTestByTestId(int testId);
}
