package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.model.Result;
import com.cybage.onlineexamsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultServiceImpl implements  ResultService {

    private static Question question = null;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private QuestionService questionService;

    @Override
    public void insertResult(Result result) {
        resultRepository.save(result);
    }

    @Override
    public void checkResponse(Response response) throws QuestionNotFoundException {
        question = questionService.getQuestionById(response.getQuestionId());
        Result result = new Result();

        result.setQuestionId(response.getQuestionId());
        result.setUserId(response.getUserId());

        if(question.getAnswer().equalsIgnoreCase(response.getResponse())) {
            result.setMarks(question.getMarks());
            result.setResult("Correct");
        }
        else {
            result.setMarks(0);
            result.setResult("Incorrect");
        }

        insertResult(result);
    }

}
