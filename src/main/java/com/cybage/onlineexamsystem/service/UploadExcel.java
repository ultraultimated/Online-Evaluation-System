/*
 * UploadExcel
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UploadExcel
 * Brief description of contents of file.
 * Long description
 * @date 11/5/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SheetCountException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */

public interface UploadExcel {

	/**
	 * @param multipartFile for excel file upload
	 */
	public void uploadFile(MultipartFile multipartFile);

	public void readFile(String filePath) throws IOException, InvalidFormatException, SheetCountException;

	public boolean checkSheetCount(int sheetCount) throws SheetCountException;

}
