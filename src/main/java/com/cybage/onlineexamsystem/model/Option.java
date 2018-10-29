package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_options database table.
 * 
 */
@Entity
@Table(name="tbl_options")
@NamedQuery(name="Option.findAll", query="SELECT t FROM Option t")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="option_a")
	private String optionA;

	@Column(name="option_b")
	private String optionB;

	@Column(name="option_c")
	private String optionC;

	@Column(name="option_d")
	private String optionD;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="option_id")
	private int optionId;

	@Column(name="question_id")
	private int questionId;

	public Option() {
	}

	public String getOptionA() {
		return this.optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return this.optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return this.optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return this.optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}