/*
 * QuestionRepository
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file QuestionRepository
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.repository;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */

import com.cybage.onlineexamsystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
