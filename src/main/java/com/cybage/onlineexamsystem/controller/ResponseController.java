package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.QuestionNotFoundException;
import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.model.Result;
import com.cybage.onlineexamsystem.service.LogService;
import com.cybage.onlineexamsystem.service.ResponseService;
import com.cybage.onlineexamsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private LogService logService;

    /**
     * insert response
     * @param responseList
     */
    @PostMapping("/insert")
    public void insertResponse(@RequestBody Response[] responseList) throws QuestionNotFoundException {
        for(Response response: responseList){
            response.setTimestamp(new Date());
            responseService.insertResponse(response);
            resultService.checkResponse(response);
        }
        logService.addLog(responseList);
    }

    /**
     * @return get all response
     */
    @GetMapping("/all")
    public List getAllResponses() {
        return responseService.getAllReponse();
    }

}