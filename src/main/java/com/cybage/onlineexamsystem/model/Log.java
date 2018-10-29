package com.cybage.onlineexamsystem.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_log database table.
 * 
 */
@Entity
@Table(name="tbl_log")
@NamedQuery(name="Log.findAll", query="SELECT t FROM Log t")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="log_id")
	private int logId;

	@Column(name="percent_obt")
	private double percentObt;

	@Column(name="test_id")
	private int testId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="user_id")
	private int userId;

	public Log() {
	}

	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
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

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}