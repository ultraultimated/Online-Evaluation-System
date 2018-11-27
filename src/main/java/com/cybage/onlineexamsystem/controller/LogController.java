package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/id/{userId}")
    private List getLogbyUserId(@PathVariable int userId) {
        return logService.getLogByUid(userId);
    }

}
