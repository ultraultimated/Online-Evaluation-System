package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PostMapping("/insert")
    public void insertResponse(@RequestBody  Response response) {
        responseService.insertResponse(response);
    }
}
