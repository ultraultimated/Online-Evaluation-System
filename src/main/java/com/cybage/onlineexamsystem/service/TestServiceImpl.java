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

import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestRepository testRepository;

	/**
	 * @return List of all tests
	 */
	@Override
	public List<Test> getAllTests() throws TestNotFoundException {

		if ((testRepository.findAll()).size() != 0) {
			return testRepository.findAll();
		} else {
			throw new TestNotFoundException();
		}
	}

	/**
	 * @param subCategoryId Id to find all tests
	 * @return List of all tests matching a category
	 */
	@Override
	public List<Test> getTestBySubCategory(int subCategoryId) throws
			TestNotFoundException {
		if ((testRepository.findAllBySubcategoryId(subCategoryId)).size() !=
		    0) {
			return testRepository.findAllBySubcategoryId(subCategoryId);
		} else {
			throw new TestNotFoundException();
		}
	}

	/**
	 * @param testId testID to find test
	 * @return test object containing all values
	 */
	@Override
	public Test getTestByTestId(int testId) throws TestNotFoundException {
		Optional<Test> optional = testRepository.findById(testId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new TestNotFoundException();
		}
	}

	/**
	 * @param test object to be inserted into database
	 */
	@Override
	public void insertTest(Test test) {
		testRepository.save(test);
	}

}
