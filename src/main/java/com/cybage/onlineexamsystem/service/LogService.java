package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Log;
import com.cybage.onlineexamsystem.model.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {

    int getTestIdformQid(int qid);

    void addLog(Response[] responseList) throws QuestionNotFoundException;

    List<Log> getLogByUid(int userid);
}
