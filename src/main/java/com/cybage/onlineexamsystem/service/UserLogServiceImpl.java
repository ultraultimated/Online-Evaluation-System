/*
 * UserLogServiceImpl
 *
 * Version information
 *
 * 11/1/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserLogServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 11/1/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.model.Log;
import com.cybage.onlineexamsystem.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Component
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    private UserLogRepository userLogRepository;

    /**
     * @param userId of user
     * @return list of all test given by the user
     */
    @Override
    public List<Log> getAllTestsByUserId(int userId) {

        return userLogRepository.getAllByUserId(userId);

    }

    /**
     * @param log the log object to be inserted
     */
    @Override
    public void insertLog(Log log) {

        userLogRepository.save(log);
    }
}
