package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_user database table.
 * 
 */
@Entity
@Table(name="tbl_user")
@NamedQuery(name="User.findAll", query="SELECT t FROM User t")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int contact;

	private String country;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String gender;

	private String name;

	private String password;

	@Id
	@Column(name="user_id")
	private int userId;

	@Column(name="user_type")
	private String userType;

	private String username;

	public User() {
	}

	public int getContact() {
		return this.contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}