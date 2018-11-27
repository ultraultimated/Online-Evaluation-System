package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Log;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.repository.LogRepository;
import com.cybage.onlineexamsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class LogServiceImpl implements LogService {

    private static Question question = null;
    private static int totalMarks = 0;
    private static int obtainedMarks = 0;


    @Autowired
    private LogRepository logRepository;
    @Autowired
    private QuestionService questionService;

    @Override
    public int getTestIdformQid(int qid) {
        return logRepository.getTestIdFromQuesId(qid);
    }

    @Override
    public void addLog(Response[] responseList) throws QuestionNotFoundException {
        int testId = logRepository.getTestIdFromQuesId(responseList[0].getQuestionId());
        int userId = responseList[0].getUserId();
        for(Response response: responseList) {
            question = questionService.getQuestionById(response.getQuestionId());

            if(question.getAnswer().equalsIgnoreCase(response.getResponse())) {
                totalMarks += question.getMarks();
                obtainedMarks += question.getMarks();
            }
            else {
                totalMarks += question.getMarks();
            }
        }
        double percent = obtainedMarks*100/totalMarks;
        Log log = new Log();
        log.setUserId(userId);
        log.setTestId(testId);
        log.setPercentObt(percent);
        log.setTimestamp(new Date());

        logRepository.save(log);

    }

    @Override
    public List<Log> getLogByUid(int userid) {
        return logRepository.getLogbyUserId(userid);
    }


}
