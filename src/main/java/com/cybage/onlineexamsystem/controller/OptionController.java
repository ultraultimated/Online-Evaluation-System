/*
 * OptionController
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file OptionController
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.OptionNotFoundException;
import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Option;
import com.cybage.onlineexamsystem.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */

@RestController
@RequestMapping("/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    /**
     * insert option
     * @param option
     */
    @PostMapping("/insert")
    private void insertOption(@RequestBody Option option) {
        optionService.insertOption(option);
    }

    /**
     * @param questionId
     * @return get all options by questionId
     * @throws QuestionNotFoundException
     */
    @GetMapping("/question/id/{questionId}")
    private Option getOptionByQuestionId(@PathVariable int questionId) throws QuestionNotFoundException {
        return optionService.getOptionByQuestionId(questionId);
    }

    /**
     * @param optionId
     * @return get options by optionId
     * @throws OptionNotFoundException
     */
    @GetMapping("/id/{optionId}")
    private Option getOptionById(@PathVariable int optionId) throws OptionNotFoundException {
        return optionService.getOptionById(optionId);
    }
}
