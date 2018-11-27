/*
 * UploadFileImpl
 *
 * Version information
 *
 * 11/27/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UploadFileImpl
 * Brief description of contents of file.
 * Long description
 * @date 11/27/2018
 */


package com.cybage.onlineexamsystem.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Component
public class UploadFileServiceImpl implements UploadFileService {
	private String rootPath = "C:\\Users\\neelp\\Desktop\\OES-git\\online" +
	                          "-evaluation-system\\src\\main\\resources" +
	                          "\\uploads";
	private final Path rootLocation = Paths.get(rootPath);

	@Override
	public void store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(),
			           this.rootLocation.resolve(file.getOriginalFilename()));
		}
		catch( Exception e ) {
			throw new RuntimeException("FAIL!");
		}
	}
}
