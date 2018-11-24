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
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/get")
    private void readFile() throws IOException, InvalidFormatException, SheetCountException {
        uploadExcelService.readFile("adsds");
    }
}
