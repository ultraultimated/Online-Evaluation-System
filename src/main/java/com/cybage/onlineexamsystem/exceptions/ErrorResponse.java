/*
 * ErrorResponse
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file ErrorResponse
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */


package com.cybage.onlineexamsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Component
public class ErrorResponse {
    private String errorMessage;
    private String errorCode;
    private HttpStatus httpStatus;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
