/*
 * Test
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file Test
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */
package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The Example interface provides ...
 *
 * @author {neelp}
 */
@Service
public interface TestService {
    /**
     * @return List of all tests
     */
    List<Test> getAllTests() throws TestNotFoundException;

    /**
     * @param subCategoryId Id to find all tests
     * @return List of tests with given subcategory ID
     */
    List<Test> getTestBySubCategoryId(int subCategoryId) throws SubCategoryNotFoundException;

    /**
     * @param testId testID to find test
     * @return Test Object
     */
    Test getTestByTestId(int testId) throws TestNotFoundException;

    void insertTest(Test test, File file) throws SubCategoryNotFoundException, IOException;

    long getSubCategoryCountByTestId(int subCategoryId) throws Exception;

//    IdMapDTO getCategoryIdSubcategoryIdByTestId(int testId);

}
