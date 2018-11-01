/*
 * ParentQuestionController
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file ParentQuestionController
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.ParentQuestionNotFoundException;
import com.cybage.onlineexamsystem.model.ParentQuestion;
import com.cybage.onlineexamsystem.service.ParentQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */

@RestController
@RequestMapping("/parentquestion")
public class ParentQuestionController {

	@Autowired
	private ParentQuestionServiceImpl parentQuestionServiceImpl;

	/**
	 * @param parentQuestion
	 */
	@PostMapping("/insert")
	private void insertParentQuestion(
			@RequestBody ParentQuestion parentQuestion) {
		parentQuestionServiceImpl.insertParentQuestion(parentQuestion);
	}

	/**
	 * @return all ParentQuestion
	 */
	@GetMapping("/all")
	private List getAllParentQuestion() {
		return parentQuestionServiceImpl.getAllParentQuestion();
	}

	/**
	 * @param testId to be found
	 * @return list of ParentQuestion of given testId
	 * @throws ParentQuestionNotFoundException
	 */
	@GetMapping("/test/id/{testId}")
	private List getParentQuestionByTestId(
			@PathVariable int testId) throws ParentQuestionNotFoundException {
		return parentQuestionServiceImpl.getParentQuestionByTestId(testId);
	}

	/**
	 * @param parentQuestionId ParentQuestion Id to be found
	 * @return ParentQuestionDescription related to the id
	 * @throws ParentQuestionNotFoundException
	 */
	@GetMapping("/id/{parentQuestionId}")
	private ParentQuestion getParentQuestionById(
			@PathVariable
					int parentQuestionId) throws
			ParentQuestionNotFoundException {
		return parentQuestionServiceImpl.getParentQuestionById
				(parentQuestionId);
	}

}
