/*
 * QuestionServiceImpl
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file QuestionServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public void insertQuestion(Question question) {
		questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public List<Question> getQuestionByParentQuestionId(int parentQuestionId)
			throws QuestionNotFoundException {
		if (questionRepository.findAllByParentQuestionId(parentQuestionId)
				    .size() != 0) {
			return questionRepository.findAllByParentQuestionId
					(parentQuestionId);
		} else {
			throw new QuestionNotFoundException();
		}
	}

	@Override
	public Question getQuestionById(int questionId) throws
			QuestionNotFoundException {
		Optional<Question> optional = questionRepository.findById
				(questionId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new QuestionNotFoundException();
		}
	}
}
