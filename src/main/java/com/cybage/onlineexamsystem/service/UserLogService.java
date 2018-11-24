/*
 * UserLogService
 *
 * Version information
 *
 * 11/1/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserLogService
 * Brief description of contents of file.
 * Long description
 * @date 11/1/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.Log;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Service
public interface UserLogService {
    /**
     * @return List of all tests given by a user
     */
    List<Log> getAllTestsByUserId(int userId);

    /**
     * @param log the log object to be inserted
     */
    void insertLog(Log log);
}
