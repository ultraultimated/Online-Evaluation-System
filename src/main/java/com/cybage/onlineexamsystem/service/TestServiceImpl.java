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

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.*;
import com.cybage.onlineexamsystem.repository.SubCategoryRepository;
import com.cybage.onlineexamsystem.repository.TestRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Example class provides ...
 *
 * @author {neelp}
 */
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestRepository testRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

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

		return subCategoryRepository.findById(subCategoryId).orElseThrow(SubCategoryNotFoundException::new).getTestList();

	}

	/**
	 * @param testId testID to find test
	 * @return test object containing all values
	 */
	@Override
	public Test getTestByTestId(int testId) throws TestNotFoundException {
		return testRepository.findById(testId).orElseThrow(TestNotFoundException::new);
	}

	/**
	 * @param test object to be inserted into database
	 */
	@Override
	public void insertTest(Test test) {
		testRepository.save(test);
	}

	public static boolean isValidParentQuestion(Row row) {

		try {
			int parentQuestionId = (int) row.getCell(0).getNumericCellValue();
			String parentQuestionDesc = row.getCell(1).getStringCellValue();
			QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(2).getStringCellValue());
			QuestionSubjectivity subjectivity = QuestionSubjectivity.valueOf(row.getCell(3).getStringCellValue());
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
					QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(4).getStringCellValue().toUpperCase());
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
					QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(5).getStringCellValue().toUpperCase());
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
					String answer = row.getCell(3).getStringCellValue();
					int marks = (int) row.getCell(4).getNumericCellValue();
					QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(5).getStringCellValue().toUpperCase());
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
					QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(9).getStringCellValue().toUpperCase());
					String subTopic = row.getCell(10).getStringCellValue();
					return !questionDescription.isEmpty() && !subTopic.isEmpty() && !option1.isEmpty() && !option2.isEmpty() && !option3.isEmpty() && !option4.isEmpty() && correctOption.isEmpty();

				} catch (Exception e) {
					return false;
				}
		}

		return false;
	}

	private static List<ParentQuestion> readParentQuestion(Sheet sheet) {

		List<ParentQuestion> parentQuestions = new ArrayList<>();

		for (int i = 1; i < sheet.getLastRowNum(); i++) {

			Row row = sheet.getRow(i);

			if (row != null && isValidParentQuestion(row)) {
				parentQuestions.add(mapRowToParentQuestion(row));
			}
		}

		return parentQuestions;
	}

	private static ParentQuestion mapRowToParentQuestion(Row row) {

		ParentQuestion parentQuestion = new ParentQuestion();

		int parentQuestionId = (int) row.getCell(0).getNumericCellValue();
		String parentQuestionDesc = row.getCell(1).getStringCellValue();
		QuestionDifficulty difficulty = QuestionDifficulty.valueOf(row.getCell(2).getStringCellValue());
		QuestionSubjectivity subjectivity = QuestionSubjectivity.valueOf(row.getCell(3).getStringCellValue());
		String topic = row.getCell(4).getStringCellValue();

		parentQuestion.setParentQuestionId(parentQuestionId);
		parentQuestion.setParentQuestionDesc(parentQuestionDesc);
		parentQuestion.setDifficulty(difficulty);
		parentQuestion.setSubjectivity(subjectivity);
		parentQuestion.setTopicName(topic);
		return parentQuestion;
	}


	private static List<Question> readQuestion(Sheet sheet, QuestionType questionType) {

		List<Question> questions = new ArrayList<>();

		for (int i = 1; i < sheet.getLastRowNum(); i++) {

			Row row = sheet.getRow(i);

			if (row != null && isValidQuestion(row, questionType)) {
				questions.add(mapRowToQuestion(row, questionType));
			}
		}

		return questions;
	}

	private static Question mapRowToQuestion(Row row, QuestionType questionType) {

		Question question = new Question();
		Option options = new Option();

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
				question.setAnswer(row.getCell(3).getStringCellValue());
				question.setMarks((int) row.getCell(4).getNumericCellValue());
				question.setDifficulty(QuestionDifficulty.valueOf(row.getCell(5).getStringCellValue().toUpperCase()));
				question.setSubtopicName(row.getCell(6).getStringCellValue());
				break;

			case MCQ:
				question.setQuestionType(QuestionType.MCQ);
				question.setParentQuestionId((int) row.getCell(1).getNumericCellValue());
				question.setQuestionDesc(row.getCell(2).getStringCellValue());
				options.setOptionA(row.getCell(3).getStringCellValue());
				options.setOptionB(row.getCell(4).getStringCellValue());
				options.setOptionC(row.getCell(5).getStringCellValue());
				options.setOptionD(row.getCell(6).getStringCellValue());
				question.setOption(options);
				question.setAnswer(row.getCell(7).getStringCellValue());
				question.setMarks((int) row.getCell(8).getNumericCellValue());
				question.setDifficulty(QuestionDifficulty.valueOf(row.getCell(9).getStringCellValue().toUpperCase()));
				question.setSubtopicName(row.getCell(10).getStringCellValue());
				break;

		}

		return question;
	}

}
