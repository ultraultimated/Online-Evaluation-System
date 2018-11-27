package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface LogService {

    int getTestIdformQid(int qid);

    void addLog(Response[] responseList) throws QuestionNotFoundException;
}
