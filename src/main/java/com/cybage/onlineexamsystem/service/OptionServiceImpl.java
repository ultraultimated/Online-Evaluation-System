/*
 * OptionServiceImpl
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file OptionServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.OptionNotFoundException;
import com.cybage.onlineexamsystem.model.Option;
import com.cybage.onlineexamsystem.repository.OptionRepository;
import com.cybage.onlineexamsystem.repository.OptionService;
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
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionRepository optionRepository;

	@Override
	public void insertOption(Option option) {
		optionRepository.save(option);
	}

	@Override
	public List<Option> getAllOption() {
		return optionRepository.findAll();
	}

	@Override
	public List<Option> getOptionByQuestionId(int questionId) throws OptionNotFoundException {
		if (optionRepository.findAllByQuestionId(questionId).size() != 0) {
			return optionRepository.findAllByQuestionId(questionId);
		} else {
			throw new OptionNotFoundException();
		}
	}

	@Override
	public Option getOptionById(int optionId) throws OptionNotFoundException {
		Optional<Option> optional = optionRepository.findById(optionId);
		if (optional.isPresent()){
			return optional.get();
		} else {
			throw new OptionNotFoundException();
		}
	}
}
