package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    /**
     * insert response
     * @param responseList
     */
    @PostMapping("/insert")
    public void insertResponse(@RequestBody Response[] responseList) {
        for(Response response: responseList){
            responseService.insertResponse(response);
        }
    }

    /**
     * @return get all response
     */
    @GetMapping("/all")
    public List getAllResponses() {
        return responseService.getAllReponse();
    }

}