/*
 * UploadExcelImpl
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UploadExcelImpl
 * Brief description of contents of file.
 * Long description
 * @date 11/5/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SheetCountException;
import com.cybage.onlineexamsystem.model.ParentQuestion;
import com.cybage.onlineexamsystem.repository.ParentQuestionRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */
@Service
public class UploadExcelImpl implements UploadExcel {
	@Autowired
	private ParentQuestionRepository parentQuestionRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param multipartFile for excel file upload
	 */
	@Override
	public void uploadFile(MultipartFile multipartFile) {

	}

	@Override
	public void readFile(String filePath) throws IOException,
			InvalidFormatException, SheetCountException {
		final String FILE_PATH = "C:\\Users\\poojanp\\Desktop\\Database.xlsx";
//		logger.warn(Boolean.toString(parentQuestionRepository == null));
		Workbook workbook = WorkbookFactory.create(new File(FILE_PATH));
//		logger.info("Number of sheets:- "+workbook.getNumberOfSheets());
		boolean isValidCount = checkSheetCount(workbook.getNumberOfSheets());


		if (isValidCount) {
			for (Sheet sheet : workbook) {
				logger.info(sheet.getSheetName());
			}

			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter dataFormatter = new DataFormatter();

			for (Row row : sheet) {
				for (Cell cell : row) {
					logger.info(cell.toString());
				}
			}


			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (checkNull(row)) {
					ParentQuestion parentQuestion = new ParentQuestion();

//					parentQuestion.setParentQuestionDesc(row.getCell(1)
//							                                     .toString());
//					parentQuestion.setDifficulty(row.getCell(2).toString());
//					parentQuestion.setSubjectivity(row.getCell(3).toString());
//					parentQuestion.setTopicName(row.getCell(4).toString());
					//parentQuestion.setTestId(1);

//					logger.info(parentQuestion.getParentQuestionDesc());
//					logger.info(parentQuestion.getDifficulty());
//					logger.info(parentQuestion.getSubjectivity());
//					logger.info(parentQuestion.getTopicName());
					//logger.info("" + parentQuestion.getTestId());

					parentQuestionRepository.save(parentQuestion);
					logger.info("\n");
				}

			}
		}
	}

	@Override
	public boolean checkSheetCount(int sheetCount) throws SheetCountException {
		if (sheetCount == 6)
			return true;
		else
			throw new SheetCountException();
	}

	@Override
	public boolean checkNull(Row row) {
		boolean response = true;
		if (row.getCell(0) == null)
			return false;
		else {

			if (response && (row.getCell(0).toString()).startsWith("IF")) {
				response = false;
			}

			return response;
		}
	}

}
