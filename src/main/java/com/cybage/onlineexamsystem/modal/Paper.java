package com.cybage.onlineexamsystem.modal;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_PAPER")
public class Paper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paper_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@Column(name = "paper_name")
	private String name;

	@Column(name = "total_marks")
	private int marks;

	@Column(name = "cutoff")
	private int cutoff;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "paper_id")
	private List< Paper > paperList;

}
