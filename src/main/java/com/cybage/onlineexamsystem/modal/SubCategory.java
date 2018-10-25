/*
 * SubCategory.java
 *
 * Version information
 *
 * Oct 24, 2018
 *
 * Copyright notice
 */

/**
 * @file SubCategory.java
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date Oct 24, 2018
 * @version v1.0
 */

package com.cybage.onlineexamsystem.modal;

import javax.persistence.*;
import java.util.List;

/**
 * @author poojanp
 *
 */
@Entity
@Table(name = "TBL_SUBCATEGORY")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    private int id;

    @Column(name = "subcategory_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private List<Paper> paperList;
}
