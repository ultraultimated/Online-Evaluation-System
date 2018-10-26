package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_subcategory database table.
 * 
 */
@Entity
@Table(name="tbl_subcategory")
@NamedQuery(name="Subcategory.findAll", query="SELECT t FROM Subcategory t")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="category_id")
	private int categoryId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subcategory_id")
	private int subcategoryId;

	@Column(name="subcategory_name")
	private String subcategoryName;

	public Subcategory() {
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