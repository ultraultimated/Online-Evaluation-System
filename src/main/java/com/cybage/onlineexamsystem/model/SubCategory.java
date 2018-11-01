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

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the tbl_subcategory database table.
 */
@Entity
@Table(name = "tbl_subcategory")
@NamedQuery(name = "Subcategory.findAll", query = "SELECT t FROM SubCategory t")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "category_id")
	private int categoryId;

	@Id
	@Column(name = "subcategory_id")
	private int subcategoryId;

	@Column(name = "subcategory_name")
	private String subcategoryName;

	public SubCategory() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

}
