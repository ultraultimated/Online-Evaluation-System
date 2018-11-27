package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ResultService {

    void insertResult(Result result);

    void checkResponse(Response response) throws QuestionNotFoundException;

}
