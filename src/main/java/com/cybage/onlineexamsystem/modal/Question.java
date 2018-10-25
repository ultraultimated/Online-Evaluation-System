package com.cybage.onlineexamsystem.modal;

import javax.persistence.*;

@Entity
@Table(name = "TBL_QUESTION")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_question_id")
    private ParentQuestion parentQuestion;

    private QuestionType questionType;

    @Column(name = "question_name")
    private String name;

    private String answer;

    private int marks;

    @Column(name = "subtopic_name")
    private String subtopic;

    @ManyToOne(fetch = FetchType.LAZY)
    private Paper paper;

}
