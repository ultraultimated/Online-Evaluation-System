package com.cybage.onlineexamsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the tbl_response database table.
 */
@Entity
@Table(name = "tbl_response")
@NamedQuery(name = "Response.findAll", query = "SELECT t FROM Response t")
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "question_id")
	private int questionId;

	private String response;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "response_id")
	private int responseId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name = "user_id")
	private int userId;

	public Response() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getResponseId() {
		return this.responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
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