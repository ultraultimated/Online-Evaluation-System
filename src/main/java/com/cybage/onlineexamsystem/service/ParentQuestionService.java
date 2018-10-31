/*
 * CategoryRepository
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryRepository
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.ParentQuestionNotFoundException;
import com.cybage.onlineexamsystem.model.ParentQuestion;

import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */

public interface ParentQuestionService {

	/**
	 * @param parentQuestion ParentQuestion object to insert in java
	 */
	public void insertParentQuestion(ParentQuestion parentQuestion);

	/**
	 * @return List of all categories in ParentQuestion table.
	 */
	public List<ParentQuestion> getAllParentQuestion();

	/**
	 * @param id the id to find ParentQuestionDescription Name
	 * @return ParentQuestionDescription name for a particular Id.
	 * @throws ParentQuestionNotFoundException
	 */
	public String getParentQuestionById(int id) throws
			ParentQuestionNotFoundException;
}