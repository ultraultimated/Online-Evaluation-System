package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.SubCategoryNotFoundException;
import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import com.cybage.onlineexamsystem.model.dto.IdMapDTO;
import com.cybage.onlineexamsystem.model.dto.TestDTO;
import com.cybage.onlineexamsystem.service.TestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param subCategoryId to find all papers
     * @return list of papers that contain the subcategroy
     * @throws SubCategoryNotFoundException if no test exist
     */
    @GetMapping("/subcategory/id/{subCategoryId}")
    private List<Test> getAllTestBySubcategroyId(@PathVariable int subCategoryId) throws SubCategoryNotFoundException {
//        Type test = new TypeToken<List<TestDTO>>() {
//        }.getType();
//        return modelMapper.map(testService.getTestBySubCategoryId(subCategoryId), test);
        return testService.getTestBySubCategoryId(subCategoryId);
    }

    @GetMapping("/subcategory/id/{subCategoryId}/count")
    private long getSubCategoryCountByTestId(@PathVariable int subCategoryId) throws Exception {
        // return testService.getSubCategoryCountByTestId(subCategoryId);
        return testService.getSubCategoryCountByTestId(subCategoryId);
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
    private Test getTestByTestId(@PathVariable int testId) throws TestNotFoundException {
        return testService.getTestByTestId(testId);
    }

    /**
     * @param testDTO to be inserted into database
     */
    @PostMapping("/insert")
    private void insertTest(@ModelAttribute TestDTO testDTO) throws SubCategoryNotFoundException, IOException {
        //final String FILE_PATH = "/Users/poojan/Desktop/online-evaluation-system/src/main/resources/Database.xlsx";
        final String FILE_PATH = "/home/poojanp/online-evaluation-system/src/main/resources/Database.xlsx";
        File file = new File(FILE_PATH);
        Test test = modelMapper.map(testDTO,Test.class);

        testService.insertTest(test, testDTO.getFile().getInputStream());
    }

    @GetMapping("/subcategory/test/{testId}")
    private IdMapDTO getCategoryIdSubcategoryIdByTestId(@PathVariable int testId) {

        Type idmap = new TypeToken<IdMapDTO>() {
        }.getType();
        return modelMapper.map(testService.getCategoryIdSubcategoryIdByTestId(testId), idmap);
//        return testService.getCategoryIdSubcategoryIdByTestId(testId);
    }

}