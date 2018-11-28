package com.cybage.onlineexamsystem.model.dto;

import java.util.List;

public class TestingTestDTO {

    private int testId;

    private List<ParentQuestionDTO> parentQuestionList;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public List<ParentQuestionDTO> getParentQuestionList() {
        return parentQuestionList;
    }

    public void setParentQuestionList(List<ParentQuestionDTO> parentQuestionList) {
        this.parentQuestionList = parentQuestionList;
    }
}
