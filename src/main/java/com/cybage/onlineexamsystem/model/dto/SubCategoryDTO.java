package com.cybage.onlineexamsystem.model.dto;

import java.util.List;

public class SubCategoryDTO {

    private int subcategoryId;

    private String subcategoryName;

    private List<TestDTO> testList;

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public List<TestDTO> getTestList() {
        return testList;
    }

    public void setTestList(List<TestDTO> testList) {
        this.testList = testList;
    }
}
