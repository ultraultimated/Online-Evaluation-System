package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.model.Response;
import com.cybage.onlineexamsystem.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    Logger logger = LoggerFactory.getLogger("info");

    @PostMapping("/insert")
    public void insertResponse(@RequestBody Response response) {
        responseService.insertResponse(response);
        logger.info("res inserted!");
    }

    @GetMapping("/all")
    public List getAllResponses() {
        return responseService.getAllReponse();
    }

}
