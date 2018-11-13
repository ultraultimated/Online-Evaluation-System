package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService testService;

	/**
	 * @param subCategoryId to find all papers
	 * @return list of papers that contain the subcategroy
	 * @throws TestNotFoundException if no test exist
	 */
	@GetMapping("/subcategory/id/{subCategoryId}")
	private List<Test> getAllTestBySubcategroyId(
			@PathVariable int subCategoryId) throws SubCategoryNotFoundException {
		return testService.getTestBySubCategoryId(subCategoryId);
	}

	/**
	 * @return all tests
	 * @throws TestNotFoundException if no test exist
	 */
	@GetMapping("/all")
	private List<Test> getAllTest() throws TestNotFoundException {
		return testService.getAllTests();
	}

	/**
	 * @param testId of the test
	 * @return test object of that test Id
	 * @throws TestNotFoundException if the test is not found of given ID
	 */
	@GetMapping("/id/{testId}")
	private Test getTestByTestId(
			@PathVariable int testId) throws TestNotFoundException {
		return testService.getTestByTestId(testId);
	}

	/**
	 * @param test to be inserted into database
	 */
	@PostMapping("/insert")
	private void insertTest(@RequestBody Test test) {
		testService.insertTest(test);
	}

}