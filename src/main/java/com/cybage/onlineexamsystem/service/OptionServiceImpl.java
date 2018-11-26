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
import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Option;
import com.cybage.onlineexamsystem.repository.OptionRepository;
import com.cybage.onlineexamsystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */
@Component
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void insertOption(Option option) {
        optionRepository.save(option);
    }

    @Override
    public List<Option> getOptionByQuestionId(int questionId) throws QuestionNotFoundException {
        return questionRepository.findById(questionId).orElseThrow(QuestionNotFoundException::new).getOptionList();
    }

    @Override
    public Option getOptionById(int optionId) throws OptionNotFoundException {
        return optionRepository.findById(optionId).orElseThrow(OptionNotFoundException::new);
    }
}
