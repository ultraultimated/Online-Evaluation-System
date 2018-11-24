/*
 * UploadExcelService
 *
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UploadExcelService
 * <p>
 * Brief description of contents of file.
 * Long description
 * @date 11/5/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SheetCountException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */
@Service
public interface UploadExcelService {

    /**
     * @param multipartFile for excel file upload
     */
    void uploadFile(MultipartFile multipartFile);

    void readFile(String filePath) throws IOException, InvalidFormatException, SheetCountException;

    boolean checkSheetCount(int sheetCount) throws SheetCountException;

    boolean checkNull(Row row);
}
