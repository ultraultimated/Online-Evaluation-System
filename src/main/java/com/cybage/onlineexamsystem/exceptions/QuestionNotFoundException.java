/*
 * QuestionNotFoundException
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file QuestionNotFoundException
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.exceptions;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */

public class QuestionNotFoundException extends Exception {

    /**
     * @param message Exception message to be thrown.
     */
    private String message;

    public QuestionNotFoundException() {

        this.message = message;
    }

    /**
     * @return the error message to the service.
     */
    @Override
    public String getMessage() {
        return message;
    }
}
