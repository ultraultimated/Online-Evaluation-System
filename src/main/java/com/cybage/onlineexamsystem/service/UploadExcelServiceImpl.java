/*
 * UploadExcelServiceImpl
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UploadExcelServiceImpl
 * Brief description of contents of file. Long description
 * @date 11/5/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.SheetCountException;
import com.cybage.onlineexamsystem.model.ParentQuestion;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.model.QuestionDifficulty;
import com.cybage.onlineexamsystem.model.QuestionSubjectivity;
import com.cybage.onlineexamsystem.repository.ParentQuestionRepository;
import com.cybage.onlineexamsystem.repository.QuestionRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides ...
 *
 * @author Poojan Patel
 */
@Component
class UploadExcelServiceImpl implements UploadExcelService {
    @Autowired
    private ParentQuestionRepository parentQuestionRepository;

    @Autowired
    private QuestionRepository questionRepository;

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

        final String FILE_PATH = "C:\\Users\\poojanp\\Desktop\\Database1.xlsx";
        //File file = new File("../src/main/resources/Database.xlsx");

        File file = new File(FILE_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(file);

//		logger.info("Number of sheets:- "+workbook.getNumberOfSheets());
        int numberOfSheets = workbook.getNumberOfSheets();
        boolean isValidCount = checkSheetCount(numberOfSheets);

        if (isValidCount) {
            for (Sheet sheet : workbook) {
                logger.info(sheet.getSheetName());
            }

            Sheet parentQuestionSheet = workbook.getSheetAt(0);
            Sheet descriptiveSheet = workbook.getSheetAt(1);
            Sheet fillInTheBlankSheet = workbook.getSheetAt(2);
            Sheet trueFalseSheet = workbook.getSheetAt(3);
            Sheet mcqSheet = workbook.getSheetAt(4);
            Sheet guidelinesSheet = workbook.getSheetAt(5);


            DataFormatter dataFormatter = new DataFormatter();

            for (Row row : parentQuestionSheet) {
                for (Cell cell : row) {
                    logger.info(cell.toString());
                }
            }

            readSheets(descriptiveSheet);

            for (int i = 1; i < parentQuestionSheet.getLastRowNum(); i++) {
                Row parentQuestionRow = parentQuestionSheet.getRow(i);
                if (checkNull(parentQuestionRow)) {
                    ParentQuestion parentQuestion = new ParentQuestion();

                    parentQuestion.setParentQuestionDesc(parentQuestionRow.getCell(1).toString());
                    parentQuestion.setDifficulty(QuestionDifficulty.valueOf(parentQuestionRow.getCell(2).getStringCellValue().toUpperCase()));
                    parentQuestion.setSubjectivity(QuestionSubjectivity.valueOf(parentQuestionRow.getCell(3).getStringCellValue().toUpperCase()));
                    parentQuestion.setTopicName(parentQuestionRow.getCell(4).toString());
                    //parentQuestion.setTestId(1);

                    for (int j = 1; j < descriptiveSheet.getLastRowNum(); j++) {
                        Row descriptiveSheetRow = descriptiveSheet.getRow(j);
                        if (checkNull(descriptiveSheetRow)) {
                            Question question = new Question();
                            List<Question> questionList = new ArrayList<>();

                            if (parentQuestionRow.getCell(0).toString().equals(descriptiveSheetRow.getCell(1).toString())) {
                                question.setQuestionDesc(descriptiveSheetRow.getCell(2).toString());
                                question.setMarks((int) (descriptiveSheetRow.getCell(3).getNumericCellValue()));
                                question.setSubtopicName(descriptiveSheetRow.getCell(5).toString());

                                //question.setParentQuestion(parentQuestion);
                                questionList.add(question);

                            }

                        }
                    }

                    logger.info(parentQuestion.getParentQuestionDesc());
                    logger.info(parentQuestion.getDifficulty().toString());
                    logger.info(parentQuestion.getSubjectivity().toString());
                    logger.info(parentQuestion.getTopicName());
                    //logger.info("" + parentQuestion.getTestId());

                    parentQuestionRepository.save(parentQuestion);
                    logger.info("\n");
                }
            }
        }
    }

    @Override
    public boolean checkSheetCount(int numberOfSheets) throws SheetCountException {
        if (numberOfSheets == 6)
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

    public void readSheets(Sheet sheet) {
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            if (checkNull(row)) {

            }
        }
    }
}
