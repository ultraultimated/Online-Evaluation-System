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
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */
@Service
public interface QuestionService {

    void insertQuestion(Question question);

    List<Question> getAllQuestion();

    List<Question> getQuestionByParentQuestionId(int parentQuestionId)
            throws ParentQuestionNotFoundException;

    Question getQuestionById(int questionId) throws
            QuestionNotFoundException;
}
