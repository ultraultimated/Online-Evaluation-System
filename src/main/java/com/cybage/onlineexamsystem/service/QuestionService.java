/*
 * QuestionService
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file QuestionService
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.ParentQuestionNotFoundException;
import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Question;

import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */

public interface QuestionService {

	public void insertQuestion(Question question);

	public List<Question> getAllQuestion();

	public List<Question> getQuestionByParentQuestionId(int parentQuestionId)
			throws ParentQuestionNotFoundException;

	public Question getQuestionById(int questionId) throws
			QuestionNotFoundException;
}
