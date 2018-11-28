package com.cybage.onlineexamsystem.model.dto;

import java.util.List;

public class ParentQuestionDTO {

    private int parentQuestionId;

    private List<QuestionDTO> questionList;

    public int getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(int parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public List<QuestionDTO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDTO> questionList) {
        this.questionList = questionList;
    }
}
