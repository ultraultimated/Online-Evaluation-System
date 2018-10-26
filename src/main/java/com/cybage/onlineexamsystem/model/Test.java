package com.cybage.onlineexamsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_TEST")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@Column(name = "test_name")
	private String name;

	@Column(name = "total_marks")
	private int marks;

	@Column(name = "cutoff")
	private int cutoff;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_id")
	private List< Test > testList;

}
