package com.cybage.onlineexamsystem.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the tbl_user_test database table.
 */
@Entity
@Table(name = "tbl_user_test")
@NamedQuery(name = "UserTest.findAll", query = "SELECT t FROM UserTest t")
public class  UserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "test_id")
	private int testId;

	@Column(name = "user_id")
	private int userId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_test_id")
	private int userTestId;

	public UserTest() {
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

	public int getUserTestId() {
		return this.userTestId;
	}

	public void setUserTestId(int userTestId) {
		this.userTestId = userTestId;
	}

}