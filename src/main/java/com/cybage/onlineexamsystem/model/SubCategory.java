/*
 * SubCategory.java
 *
 * Version information
 *
 * Oct 24, 2018
 *
 * Copyright notice
 */

/**
 * @file SubCategory.java
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date Oct 24, 2018
 * @version v1.0
 */

package com.cybage.onlineexamsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the tbl_subcategory database table.
 */
@Entity
@Table(name = "tbl_subcategory")
@NamedQuery(name = "Subcategory.findAll", query = "SELECT t FROM SubCategory t")
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int subcategoryId;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subcategory_id")
    private List<Test> testList;

    public SubCategory() {
    }

    public int getSubcategoryId() {
        return this.subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return this.subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

}
