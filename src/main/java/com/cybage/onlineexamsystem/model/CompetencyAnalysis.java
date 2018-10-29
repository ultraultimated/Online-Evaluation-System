package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_competency_analysis database table.
 * 
 */
@Entity
@Table(name="tbl_competency_analysis")
@NamedQuery(name="CompetencyAnalysis.findAll", query="SELECT t FROM CompetencyAnalysis t")
public class CompetencyAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="competency_id")
	private int competencyId;

	@Column(name="percent_obt")
	private double percentObt;

	@Column(name="test_id")
	private int testId;

	@Column(name="topic_name")
	private String topicName;

	@Column(name="user_id")
	private int userId;

	public CompetencyAnalysis() {
	}

	public int getCompetencyId() {
		return this.competencyId;
	}

	public void setCompetencyId(int competencyId) {
		this.competencyId = competencyId;
	}

	public double getPercentObt() {
		return this.percentObt;
	}

	public void setPercentObt(double percentObt) {
		this.percentObt = percentObt;
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}