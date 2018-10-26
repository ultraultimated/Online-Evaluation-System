package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_parent_question database table.
 * 
 */
@Entity
@Table(name="tbl_parent_question")
@NamedQuery(name="ParentQuestion.findAll", query="SELECT t FROM ParentQuestion t")
public class ParentQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String difficulty;

	@Column(name="parent_question_desc")
	private String parentQuestionDesc;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parent_question_id")
	private int parentQuestionId;

	private String subjectivity;

	@Column(name="test_id")
	private int testId;

	@Column(name="topic_name")
	private String topicName;

	public ParentQuestion() {
	}

	public String getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {
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

	public String getSubjectivity() {
		return this.subjectivity;
	}

	public void setSubjectivity(String subjectivity) {
		this.subjectivity = subjectivity;
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}