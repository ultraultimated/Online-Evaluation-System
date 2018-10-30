/*
 * CategoryNotFoundException
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryNotFoundException
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/29/2018
 */


package com.cybage.onlineexamsystem.exceptions;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
public class CategoryNotFoundException extends Exception {

	/**
	 * @param message Exception message to be thrown.
	 */
	private String message;

	public CategoryNotFoundException(String message) {
		super(message);
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
