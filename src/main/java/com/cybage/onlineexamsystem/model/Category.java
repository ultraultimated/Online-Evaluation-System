/*
 * Category.java
 *
 * Version information
 *
 * Oct 24, 2018
 *
 * Copyright notice
 */

/**
 * @file Category.java
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
 * The persistent class for the tbl_category database table.
 * 
 */
@Entity
@Table(name="tbl_category")
@NamedQuery(name="Category.findAll", query="SELECT t FROM Category t")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="category_name")
	private String categoryName;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
