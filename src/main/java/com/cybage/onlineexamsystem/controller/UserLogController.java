/*
 * UserLogController
 *
 * Version information
 *
 * 11/1/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserLogController
 * Brief description of contents of file.
 * Long description
 * @date 11/1/2018
 */


package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.model.Log;
import com.cybage.onlineexamsystem.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@RestController
@RequestMapping("/log")
public class UserLogController {
	@Autowired
	private UserLogService userLogService;

	/**
	 * @param userId of the user
	 * @return list of all tests
	 */
	@GetMapping("/test/user/id/{userId}")
	private List<Log> getAllTestByUserId(@PathVariable int userId) {
		return userLogService.getAllTestsByUserId(userId);
	}

	@PostMapping("/insert")
	private void insertLog(@RequestBody Log log) {
		userLogService.insertLog(log);
	}
}
