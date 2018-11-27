/*
 * OptionService
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file OptionService
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.OptionNotFoundException;
import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Option;
import org.springframework.stereotype.Service;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */
@Service
public interface OptionService {

    void insertOption(Option option);

    Option getOptionByQuestionId(int questionId) throws QuestionNotFoundException;

    Option getOptionById(int optionId) throws OptionNotFoundException;
}
