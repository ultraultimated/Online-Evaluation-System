package com.cybage.onlineexamsystem.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the tbl_question database table.
 */
@Entity
@Table(name = "tbl_question")
@NamedQuery(name = "Question.findAll", query = "SELECT t FROM Question t")
public class Question implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String answer;

    private int marks;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_desc")
    private String questionDesc;

    @Column(name = "question_type")
    private QuestionType questionType;

    @Column(name = "subtopic_name")
    private String subtopicName;

    @Transient
    @JsonIgnore
    private int parentQuestionId;

    private QuestionDifficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "parent_question_id")
    @JsonIgnore
    private ParentQuestion parentQuestion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Option option;

    public Question()
    {
    }

    public String getAnswer()
    {
	return this.answer;
    }

    public void setAnswer(String answer)
    {
	this.answer = answer;
    }

    public int getMarks()
    {
	return this.marks;
    }

    public void setMarks(int marks)
    {
	this.marks = marks;
    }

    public int getQuestionId()
    {
	return this.questionId;
    }

    public void setQuestionId(int questionId)
    {
	this.questionId = questionId;
    }

    public String getQuestionDesc()
    {
	return this.questionDesc;
    }

    public void setQuestionDesc(String questionDesc)
    {
	this.questionDesc = questionDesc;
    }

    public QuestionType getQuestionType()
    {
	return questionType;
    }

    public void setQuestionType(QuestionType questionType)
    {
	this.questionType = questionType;
    }

    public String getSubtopicName()
    {
	return this.subtopicName;
    }

    public void setSubtopicName(String subtopicName)
    {
	this.subtopicName = subtopicName;
    }

    public int getParentQuestionId()
    {
	return parentQuestionId;
    }

    public void setParentQuestionId(int parentQuestionId)
    {
	this.parentQuestionId = parentQuestionId;
    }

    public QuestionDifficulty getDifficulty()
    {
	return difficulty;
    }

    public void setDifficulty(QuestionDifficulty difficulty)
    {
	this.difficulty = difficulty;
    }

    public ParentQuestion getParentQuestion()
    {
	return parentQuestion;
    }

    public void setParentQuestion(ParentQuestion parentQuestion)
    {
	this.parentQuestion = parentQuestion;
    }

    public Option getOption()
    {
	return option;
    }

    public void setOption(Option option)
    {
	this.option = option;
    }
}
