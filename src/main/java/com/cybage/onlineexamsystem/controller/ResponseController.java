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

    @PostMapping("/insert")
    public void insertResponse(@RequestBody Response response) {
        responseService.insertResponse(response);
    }

    @GetMapping("/all")
    public List getAllResponses() {
        return responseService.getAllReponse();
    }

}
