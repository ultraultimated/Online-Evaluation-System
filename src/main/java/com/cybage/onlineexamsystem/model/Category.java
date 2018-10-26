/*
 * Category.java
 *
 * Version information
 *
 * Oct 24, 2018
 *
 * Copyright notice
 */

/**
 * @file Category.java
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date Oct 24, 2018
 * @version v1.0
 */

package com.cybage.onlineexamsystem.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * @author poojanp
 */
@Entity
@Table(name = "TBL_CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
//    @JoinColumn(name = "category_id")
    private Set<SubCategory> subCategoryList;

}
