package com.cybage.onlineexamsystem.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the tbl_subskill_analysis database table.
 */
@Entity
@Table(name = "tbl_subskill_analysis")
@NamedQuery(name = "SubskillAnalysis.findAll", query = "SELECT t FROM " +
        "SubskillAnalysis t")
public class SubskillAnalysis implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "percent_obt")
    private double percentObt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subskill_id")
    private int subskillId;

    @Column(name = "subtopic_name")
    private String subtopicName;

    @Column(name = "test_id")
    private int testId;

    @Column(name = "user_id")
    private int userId;

    public SubskillAnalysis() {
    }

    public double getPercentObt() {
        return this.percentObt;
    }

    public void setPercentObt(double percentObt) {
        this.percentObt = percentObt;
    }

    public int getSubskillId() {
        return this.subskillId;
    }

    public void setSubskillId(int subskillId) {
        this.subskillId = subskillId;
    }

    public String getSubtopicName() {
        return this.subtopicName;
    }

    public void setSubtopicName(String subtopicName) {
        this.subtopicName = subtopicName;
    }

    public int getTestId() {
        return this.testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}