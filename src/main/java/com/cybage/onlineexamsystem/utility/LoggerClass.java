/*
 * LoggerClass
 *
 * Version information
 *
 * 10/29/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file LoggerClass
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/29/2018
 */


package com.cybage.onlineexamsystem.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Example class provides ...

 @author {neelp}
 @version
 */
@Component
public class LoggerClass
{
	/**
	 *
	 * @param className The class Name to get logger of that class
	 * @return instance of Logger
	 */
	public Logger getLogger(Class className)
	{
		Logger logger = LoggerFactory.getLogger(className);
		return logger;
	}
}
