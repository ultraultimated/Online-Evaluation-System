/*
 * QuestionController
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file QuestionController
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.ParentQuestionNotFoundException;
import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionServiceImpl questionServiceImpl;

	@PostMapping("/insert")
	private void insertQuestion(@RequestBody Question question) {
		questionServiceImpl.insertQuestion(question);
	}

	@GetMapping("/all")
	private List getAllQuestion(){
		return questionServiceImpl.getAllQuestion();
	}

	@GetMapping("/parentQuestion/id/{parentQuestionId}")
	private List getQuestionByParentQuestionId(@PathVariable int parentQuestionId) throws ParentQuestionNotFoundException {
		return questionServiceImpl.getQuestionByParentQuestionId(parentQuestionId);
	}

	@GetMapping("/id/{questionId}")
	private Question getQuestionById(@PathVariable int questionId) throws QuestionNotFoundException {
		return questionServiceImpl.getQuestionById(questionId);
	}
}
