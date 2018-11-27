/*
 * uploadFile
 *
 * Version information
 *
 * 11/27/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file uploadFile
 * Brief description of contents of file.
 * Long description
 * @date 11/27/2018
 */
package com.cybage.onlineexamsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * The Example interface provides ...
 *
 * @author {neelp}
 */
@Service
public interface UploadFileService {
	void store(MultipartFile file);
}
