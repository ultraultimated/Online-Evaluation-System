/*
 * UploadController
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UploadController
 * Brief description of contents of file.
 * Long description
 * @date 11/5/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.SheetCountException;
import com.cybage.onlineexamsystem.service.UploadExcelService;
import com.cybage.onlineexamsystem.service.UploadFileService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadExcelService uploadExcelService;
	@Autowired
	private UploadFileService uploadFileService;

    @GetMapping("/get")
    private void readFile() throws IOException, InvalidFormatException, SheetCountException {
        uploadExcelService.readFile("adsds");
    }

	@PostMapping("/file")
	private ResponseEntity<String> handleFileUpload(
			@RequestParam("file") MultipartFile file)
	{
		String message = "";
		try {
			uploadFileService.store(file);
			return ResponseEntity.status(HttpStatus.OK).body(message);
		}
		catch( Exception e ) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
					"failed");
		}
	}

}
