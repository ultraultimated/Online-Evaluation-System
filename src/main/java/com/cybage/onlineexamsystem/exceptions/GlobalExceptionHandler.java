/*
 * GlobalExceptionHandler
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file GlobalExceptionHandler
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */


package com.cybage.onlineexamsystem.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private ErrorResponse errorResponse;

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleCategoryNotFoundException(CategoryNotFoundException exception) {
		errorResponse.setErrorMessage("Category with given ID does not exist");
		errorResponse.setErrorCode("500");
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorResponse;
	}

	@ExceptionHandler(SubCategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleSubCategoryException()
	{
		errorResponse.setErrorMessage("Subcategory with given category Id is not found");
		errorResponse.setErrorCode("500");
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorResponse;
	}

	@ExceptionHandler(ParentQuestionNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleParentQuestionException()
	{
		errorResponse.setErrorMessage("ParentQuestion with given category Id is not found");
		errorResponse.setErrorCode("500");
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorResponse;
	}

	@ExceptionHandler(QuestionNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleQuestionException()
	{
		errorResponse.setErrorMessage("Question with given ParentQuestion Id is not found");
		errorResponse.setErrorCode("500");
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorResponse;
	}

	@ExceptionHandler(OptionNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleOptionException()
	{
		errorResponse.setErrorMessage("Option with given Question Id is not found");
		errorResponse.setErrorCode("500");
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorResponse;
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleUserNotFoundException()
	{
		errorResponse.setErrorMessage("User not found");
		errorResponse.setErrorCode("500");
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return errorResponse;
	}

	@ExceptionHandler(SheetCountException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ErrorResponse sheetCountException()
	{
		errorResponse.setErrorMessage("sheet count must be 6");
		errorResponse.setErrorCode("100");
		errorResponse.setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
		return errorResponse;
	}


}
