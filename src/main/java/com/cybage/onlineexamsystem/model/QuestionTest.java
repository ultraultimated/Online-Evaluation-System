package com.cybage.onlineexamsystem.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the tbl_question_test database table.
 */
@Entity
@Table(name = "tbl_question_test")
@NamedQuery(name = "QuestionTest.findAll", query = "SELECT t FROM " +
        "QuestionTest t")
public class QuestionTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "question_id")
    private int questionId;

    @Column(name = "parent_question_id")
    private int parentQuestionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_test_id")
    private int questionTestId;

    @Column(name = "test_id")
    private int testId;

    public QuestionTest() {
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(int parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public int getQuestionTestId() {
        return this.questionTestId;
    }

    public void setQuestionTestId(int questionTestId) {
        this.questionTestId = questionTestId;
    }

    public int getTestId() {
        return this.testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

}