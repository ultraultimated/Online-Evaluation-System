package com.cybage.onlineexamsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_test database table.
 */
@Entity
@Table(name = "tbl_test")
@NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    private int cutoff;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "total_marks")
    private int totalMarks;

    @Column(name = "time")
    private Date time;

    @Transient
    private int subCategoryId;

//	@ManyToOne
//	@JoinColumn(name = "subcategory_id")
//	@JsonIgnore
//	private SubCategory subCategory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private List<ParentQuestion> parentQuestionList;

    public Test() {
    }

    public int getCutoff() {
        return this.cutoff;
    }

    public void setCutoff(int cutoff) {
        this.cutoff = cutoff;
    }

    public int getTestId() {
        return this.testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return this.testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }


    //	public SubCategory getSubCategory() {
//		return subCategory;
//	}
//
//	public void setSubCategory(SubCategory subCategory) {
//		this.subCategory = subCategory;
//	}

    public List<ParentQuestion> getParentQuestionList() {
        return parentQuestionList;
    }

    public void setParentQuestionList(List<ParentQuestion>
                                              parentQuestionList) {
        this.parentQuestionList = parentQuestionList;
    }
}
