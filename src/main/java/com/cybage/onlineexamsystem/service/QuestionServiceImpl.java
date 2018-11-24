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

import com.cybage.onlineexamsystem.exceptions.ParentQuestionNotFoundException;
import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.repository.ParentQuestionRepository;
import com.cybage.onlineexamsystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ParentQuestionRepository parentQuestionRepository;

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
            throws ParentQuestionNotFoundException {
        return parentQuestionRepository.findById(parentQuestionId).orElseThrow(ParentQuestionNotFoundException::new).getQuestionList();
    }

    @Override
    public Question getQuestionById(int questionId) throws
            QuestionNotFoundException {
        return questionRepository.findById(questionId).orElseThrow(QuestionNotFoundException::new);
    }
}
