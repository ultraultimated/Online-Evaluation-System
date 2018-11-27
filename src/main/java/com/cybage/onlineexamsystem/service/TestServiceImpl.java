/*
 * TestServiceImpl
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file TestServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cybage.onlineexamsystem.model.dto.IdMapDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Option;
import com.cybage.onlineexamsystem.model.ParentQuestion;
import com.cybage.onlineexamsystem.model.Question;
import com.cybage.onlineexamsystem.model.QuestionDifficulty;
import com.cybage.onlineexamsystem.model.QuestionSubjectivity;
import com.cybage.onlineexamsystem.model.QuestionType;
import com.cybage.onlineexamsystem.model.SubCategory;
import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import com.cybage.onlineexamsystem.repository.TestRepository;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Component
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public static boolean isValidParentQuestion(Row row) {

        try {
            int tempId = (int) row.getCell(0).getNumericCellValue();
            String parentQuestionDesc = row.getCell(1).getStringCellValue();
            QuestionDifficulty difficulty = QuestionDifficulty
                    .valueOf(row.getCell(2).getStringCellValue().toUpperCase());
            QuestionSubjectivity subjectivity = QuestionSubjectivity
                    .valueOf(row.getCell(3).getStringCellValue().toUpperCase());
            String topic = row.getCell(4).getStringCellValue();
            return !parentQuestionDesc.isEmpty();

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidQuestion(Row row, QuestionType questionType) {

        switch (questionType) {

            case DESCRIPTIVE:
                try {

                    int id = (int) row.getCell(0).getNumericCellValue();
                    int parentQuestionID = (int) row.getCell(1).getNumericCellValue();
                    String questionDescription = row.getCell(2).getStringCellValue();
                    int marks = (int) row.getCell(3).getNumericCellValue();
                    QuestionDifficulty difficulty = QuestionDifficulty
                            .valueOf(row.getCell(4).getStringCellValue().toUpperCase());
                    String subTopic = row.getCell(5).getStringCellValue();
                    return !questionDescription.isEmpty() && !subTopic.isEmpty();

                } catch (Exception e) {
                    return false;
                }

            case FILL_IN_THE_BLANKS:
                try {

                    int id = (int) row.getCell(0).getNumericCellValue();
                    int parentQuestionID = (int) row.getCell(1).getNumericCellValue();
                    String questionDescription = row.getCell(2).getStringCellValue();
                    String answer = row.getCell(3).getStringCellValue();
                    int marks = (int) row.getCell(4).getNumericCellValue();
                    QuestionDifficulty difficulty = QuestionDifficulty
                            .valueOf(row.getCell(5).getStringCellValue().toUpperCase());
                    String subTopic = row.getCell(6).getStringCellValue();
                    return !questionDescription.isEmpty() && !subTopic.isEmpty() && !answer.isEmpty();

                } catch (Exception e) {
                    return false;
                }

            case TRUE_FALSE:
                try {

                    int id = (int) row.getCell(0).getNumericCellValue();
                    int parentQuestionID = (int) row.getCell(1).getNumericCellValue();
                    String questionDescription = row.getCell(2).getStringCellValue();
                    String answer = String.valueOf(row.getCell(3).getBooleanCellValue());
                    int marks = (int) row.getCell(4).getNumericCellValue();
                    QuestionDifficulty difficulty = QuestionDifficulty
                            .valueOf(row.getCell(5).getStringCellValue().toUpperCase());
                    String subTopic = row.getCell(6).getStringCellValue();
                    return !questionDescription.isEmpty() && !subTopic.isEmpty() && !answer.isEmpty();

                } catch (Exception e) {
                    return false;
                }

            case MCQ:
                try {

                    int id = (int) row.getCell(0).getNumericCellValue();
                    int parentQuestionID = (int) row.getCell(1).getNumericCellValue();
                    String questionDescription = row.getCell(2).getStringCellValue();
                    String option1 = row.getCell(3).getStringCellValue();
                    String option2 = row.getCell(4).getStringCellValue();
                    String option3 = row.getCell(5).getStringCellValue();
                    String option4 = row.getCell(6).getStringCellValue();
                    String correctOption = row.getCell(7).getStringCellValue();
                    int marks = (int) row.getCell(8).getNumericCellValue();
                    QuestionDifficulty difficulty = QuestionDifficulty
                            .valueOf(row.getCell(9).getStringCellValue().toUpperCase());
                    String subTopic = row.getCell(10).getStringCellValue();
                    return !questionDescription.isEmpty() && !subTopic.isEmpty() && !option1.isEmpty() && !option2.isEmpty()
                            && !option3.isEmpty() && !option4.isEmpty() && !correctOption.isEmpty();

                } catch (Exception e) {
                    return false;
                }
        }

        return false;
    }

    private static List<ParentQuestion> readParentQuestion(Sheet sheet) {

        List<ParentQuestion> parentQuestions = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            if (row != null && isValidParentQuestion(row)) {
                parentQuestions.add(mapRowToParentQuestion(row));
            }
        }

        return parentQuestions;
    }

    private static ParentQuestion mapRowToParentQuestion(Row row) {

        ParentQuestion parentQuestion = new ParentQuestion();

        int tempId = (int) row.getCell(0).getNumericCellValue();
        String parentQuestionDesc = row.getCell(1).getStringCellValue();
        QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(2).getStringCellValue().toUpperCase());
        QuestionSubjectivity subjectivity = QuestionSubjectivity
                .valueOf(row.getCell(3).getStringCellValue().toUpperCase());
        String topic = row.getCell(4).getStringCellValue();

        parentQuestion.setTempId(tempId);
        parentQuestion.setParentQuestionDesc(parentQuestionDesc);
        parentQuestion.setDifficulty(difficulty);
        parentQuestion.setSubjectivity(subjectivity);
        parentQuestion.setTopicName(topic);
        return parentQuestion;
    }

    private static List<Question> readQuestion(Sheet sheet, QuestionType questionType) {

        List<Question> questions = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            if (row != null && isValidQuestion(row, questionType)) {
                questions.add(mapRowToQuestion(row, questionType));
            }
        }

        return questions;
    }

    private static Question mapRowToQuestion(Row row, QuestionType questionType) {

        Question question = new Question();

        switch (questionType) {

            case DESCRIPTIVE:
                question.setQuestionType(QuestionType.DESCRIPTIVE);
                question.setParentQuestionId((int) row.getCell(1).getNumericCellValue());
                question.setQuestionDesc(row.getCell(2).getStringCellValue());
                question.setMarks((int) row.getCell(3).getNumericCellValue());
                question.setDifficulty(QuestionDifficulty.valueOf(row.getCell(4).getStringCellValue().toUpperCase()));
                question.setSubtopicName(row.getCell(5).getStringCellValue());
                break;

            case FILL_IN_THE_BLANKS:
                question.setQuestionType(QuestionType.FILL_IN_THE_BLANKS);
                question.setParentQuestionId((int) row.getCell(1).getNumericCellValue());
                question.setQuestionDesc(row.getCell(2).getStringCellValue());
                question.setAnswer(row.getCell(3).getStringCellValue());
                question.setMarks((int) row.getCell(4).getNumericCellValue());
                question.setDifficulty(QuestionDifficulty.valueOf(row.getCell(5).getStringCellValue().toUpperCase()));
                question.setSubtopicName(row.getCell(6).getStringCellValue());
                break;

            case TRUE_FALSE:
                question.setQuestionType(QuestionType.TRUE_FALSE);
                question.setParentQuestionId((int) row.getCell(1).getNumericCellValue());
                question.setQuestionDesc(row.getCell(2).getStringCellValue());
                question.setAnswer(String.valueOf(row.getCell(3).getBooleanCellValue()));
                question.setMarks((int) row.getCell(4).getNumericCellValue());
                question.setDifficulty(QuestionDifficulty.valueOf(row.getCell(5).getStringCellValue().toUpperCase()));
                question.setSubtopicName(row.getCell(6).getStringCellValue());
                break;

            case MCQ:
                question.setQuestionType(QuestionType.MCQ);
                question.setParentQuestionId((int) row.getCell(1).getNumericCellValue());
                question.setQuestionDesc(row.getCell(2).getStringCellValue());

                Option option = new Option();
                option.setOptionA(row.getCell(3).getStringCellValue());
                option.setOptionB(row.getCell(4).getStringCellValue());
                option.setOptionC(row.getCell(5).getStringCellValue());
                option.setOptionD(row.getCell(6).getStringCellValue());
                question.setOption(option);
                //option.setQuestion(question);

                question.setAnswer(row.getCell(7).getStringCellValue());
                question.setMarks((int) row.getCell(8).getNumericCellValue());
                question.setDifficulty(QuestionDifficulty.valueOf(row.getCell(9).getStringCellValue().toUpperCase()));
                question.setSubtopicName(row.getCell(10).getStringCellValue());
                break;

        }

        return question;

    }

    /**
     * @return List of all tests
     */
    @Override
    public List<Test> getAllTests() {

        return testRepository.findAll();
    }

    /**
     * @param subCategoryId Id to find all tests
     * @return List of all tests matching a category
     */
    @Override
    public List<Test> getTestBySubCategoryId(int subCategoryId) throws SubCategoryNotFoundException {

        return subCategoryRepository.findById(subCategoryId).orElseThrow(SubCategoryNotFoundException::new)
                .getTestList();

    }

    /**
     * @param testId testID to find test
     * @return test object containing all values
     */
    @Override
    public Test getTestByTestId(int testId) throws TestNotFoundException {
        return testRepository.findById(testId).orElseThrow(TestNotFoundException::new);
    }

    @Override
    public long getSubCategoryCountByTestId(int subCategoryId) throws Exception {
        return testRepository.countBySubcategoryId(subCategoryId);
    }



    /**
     * @param test object to be inserted into database
     */
    @Override
    public void insertTest(Test test, File file) throws SubCategoryNotFoundException, IOException {

        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet parentQuestionSheet = workbook.getSheetAt(0);
        XSSFSheet descriptiveQuestionSheet = workbook.getSheetAt(1);
        XSSFSheet fillInTheBlanksQuestionSheet = workbook.getSheetAt(2);
        XSSFSheet trueFalseQuestionSheet = workbook.getSheetAt(3);
        XSSFSheet mcqQuestionSheet = workbook.getSheetAt(4);

        List<ParentQuestion> parentQuestions = readParentQuestion(parentQuestionSheet);
        List<Question> descriptiveQuestions = readQuestion(descriptiveQuestionSheet, QuestionType.DESCRIPTIVE);
        List<Question> fillInTheBlanksQuestions = readQuestion(fillInTheBlanksQuestionSheet,
                QuestionType.FILL_IN_THE_BLANKS);
        List<Question> trueFlaseQuestions = readQuestion(trueFalseQuestionSheet, QuestionType.TRUE_FALSE);
        List<Question> mcqQuestions = readQuestion(mcqQuestionSheet, QuestionType.MCQ);

        Map<Integer, List<Question>> descriptiveQuestionsById = descriptiveQuestions.stream()
                .collect(Collectors.groupingBy(Question::getParentQuestionId));
        Map<Integer, List<Question>> fillInTheBlanksQuestionsById = fillInTheBlanksQuestions.stream()
                .collect(Collectors.groupingBy(Question::getParentQuestionId));
        Map<Integer, List<Question>> trueFalseQuestionsById = trueFlaseQuestions.stream()
                .collect(Collectors.groupingBy(Question::getParentQuestionId));
        Map<Integer, List<Question>> mcqQuestionsById = mcqQuestions.stream()
                .collect(Collectors.groupingBy(Question::getParentQuestionId));

        for (ParentQuestion parentQuestion : parentQuestions) {

            int tempId = parentQuestion.getTempId();
            List<Question> questions = new ArrayList<>();
            List<Question> empty = new ArrayList<>();

            switch (parentQuestion.getSubjectivity()) {
                case DESCRIPTIVE:
                    questions.addAll(descriptiveQuestionsById.getOrDefault(tempId, empty));
                    questions.addAll(fillInTheBlanksQuestionsById.getOrDefault(tempId, empty));
                    break;

                case OBJECTIVE:
                    questions.addAll(trueFalseQuestionsById.getOrDefault(tempId, empty));
                    questions.addAll(mcqQuestionsById.getOrDefault(tempId, empty));
                    break;
            }
            parentQuestion.setQuestionList(questions);
        }

        test.setParentQuestionList(parentQuestions);
        SubCategory subCategory = subCategoryRepository.findById(test.getSubcategoryId())
                .orElseThrow(SubCategoryNotFoundException::new);
        subCategory.getTestList().add(test);
        subCategoryRepository.save(subCategory);
        // testRepository.save(test);
    }

//    @Override
//    public IdMapDTO getCategoryIdSubcategoryIdByTestId(int testId) {
//        return testRepository.findTestByTestId(testId);
//    }

}
