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

package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.exceptions.OptionNotFoundException;
import com.cybage.onlineexamsystem.model.Option;

import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */

public interface OptionService {

	public void insertOption(Option option);

	public List<Option> getAllOption();

	public List<Option> getOptionByQuestionId(int questionId) throws OptionNotFoundException;

	public Option getOptionById(int optionId) throws OptionNotFoundException;
}
