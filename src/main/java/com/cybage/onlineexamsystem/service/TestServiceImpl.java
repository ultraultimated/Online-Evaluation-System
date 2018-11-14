/*
 * TestServiceImpl
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file TestServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import com.cybage.onlineexamsystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestRepository testRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	/**
	 * @return List of all tests
	 */
	@Override
	public List<Test> getAllTests() {

		return testRepository.findAll();
	}

	/**
	 * @param subCategoryId Id to find all tests
	 * @return List of all tests matching a category
	 */
	@Override
	public List<Test> getTestBySubCategoryId(int subCategoryId) throws SubCategoryNotFoundException {

		return subCategoryRepository.findById(subCategoryId).orElseThrow(SubCategoryNotFoundException::new).getTestList();

	}

	/**
	 * @param testId testID to find test
	 * @return test object containing all values
	 */
	@Override
	public Test getTestByTestId(int testId) throws TestNotFoundException {
		return testRepository.findById(testId).orElseThrow(TestNotFoundException::new);
	}

	/**
	 * @param test object to be inserted into database
	 */
	@Override
	public void insertTest(Test test) {
		testRepository.save(test);
	}

}
