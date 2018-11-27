/*
 * UserNotFoundException
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserNotFoundException
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/31/2018
 */


package com.cybage.onlineexamsystem.exceptions;

/**
 * The Example class provides ...
 *
 * @author {rahulpandy}
 */
public class UserNotFoundException extends Exception {
    /**
     * @param message Exception message to be thrown.
     */
    private String message;

    public UserNotFoundException() {

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
