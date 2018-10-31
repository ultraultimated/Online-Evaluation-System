/*
 * ParentQuestionServiceImpl
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file ParentQuestionServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.ParentQuestionNotFoundException;
import com.cybage.onlineexamsystem.model.ParentQuestion;
import com.cybage.onlineexamsystem.repository.ParentQuestionRepository;
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
public class ParentQuestionServiceImpl implements ParentQuestionService {

	@Autowired
	private ParentQuestionRepository parentQuestionRepository;

	/**
	 * @param parentQuestion object with values to save in database
	 */
	@Override
	public void insertParentQuestion(ParentQuestion parentQuestion) {
		parentQuestionRepository.save(parentQuestion);
	}

	/**
	 * @return List of all categories in ParentQuestion table.
	 */
	@Override
	public List<ParentQuestion> getAllParentQuestion() {
		return parentQuestionRepository.findAll();
	}

	/**
	 * @param id the id to find ParentQuestionDescription Name
	 * @return ParentQuestionDescription name for a particular Id.
	 * @throws ParentQuestionNotFoundException
	 */
	@Override
	public String getParentQuestionById(int id) throws ParentQuestionNotFoundException {

		Optional<ParentQuestion> optional = parentQuestionRepository.findById(id);
		if (optional.isPresent()) {
			ParentQuestion parentQuestion = optional.get();
			return parentQuestion.getParentQuestionDesc();
		} else {
			throw new ParentQuestionNotFoundException();
		}
	}
}
