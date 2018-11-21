package com.cybage.onlineexamsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the tbl_parent_question database table.
 */
@Entity
@Table(name = "tbl_parent_question")
@NamedQuery(name = "ParentQuestion.findAll", query = "SELECT t FROM " +
                                                     "ParentQuestion t")
public class ParentQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	private QuestionDifficulty difficulty;

	@Column(name = "parent_question_desc")
	private String parentQuestionDesc;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_question_id")
	private int parentQuestionId;

	private QuestionSubjectivity subjectivity;

	@Column(name = "topic_name")
	private String topicName;

//	@ManyToOne
//	@JoinColumn(name = "test_id")
//	@JsonIgnore
//	private Test test;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_question_id")
	private List<Question> questionList;

	@Transient
	private int tempId;

	public ParentQuestion() {
	}

	public QuestionDifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(QuestionDifficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getParentQuestionDesc() {
		return this.parentQuestionDesc;
	}

	public void setParentQuestionDesc(String parentQuestionDesc) {
		this.parentQuestionDesc = parentQuestionDesc;
	}

	public int getParentQuestionId() {
		return this.parentQuestionId;
	}

	public void setParentQuestionId(int parentQuestionId) {
		this.parentQuestionId = parentQuestionId;
	}

	public QuestionSubjectivity getSubjectivity() {
		return subjectivity;
	}

	public void setSubjectivity(QuestionSubjectivity subjectivity) {
		this.subjectivity = subjectivity;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

//	public Test getTest() {
//		return test;
//	}
//
//	public void setTest(Test test) {
//		this.test = test;
//	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public int getTempId() {
		return tempId;
	}

	public void setTempId(int tempId) {
		this.tempId = tempId;
	}


}
