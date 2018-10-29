package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_user_test database table.
 * 
 */
@Entity
@Table(name="tbl_user_test")
@NamedQuery(name="UserTest.findAll", query="SELECT t FROM UserTest t")
public class UserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="test_id")
	private int testId;

	@Column(name="user_id")
	private int userId;

	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
=======
>>>>>>> 3b3ff5da303c75ccab83476e04e4557f355f4788
	@Column(name="user_test_id")
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