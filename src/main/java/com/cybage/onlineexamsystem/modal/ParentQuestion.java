package com.cybage.onlineexamsystem.modal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_PARENT_QUESTION")
public class ParentQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_question_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paper_id")
	private Paper paper;

	@Column(name = "parent_question_desc")
	private String name;

	private QuestionDifficulty difficulty;

	private QuestionSubjectivity subjectivity;

	@Column(name = "topic_name")
	private String topic;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_question_id")
	private List< Question > questionList;

}
