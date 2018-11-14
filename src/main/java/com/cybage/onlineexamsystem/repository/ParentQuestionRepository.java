/*
 * CategoryRepository
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryRepository
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.ParentQuestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Category interface Repository provides access to database by using
 * spring-data-JPA
 * This interface implements JpaRepository to provide basic functionality of
 * creating, retrieving, updating and deleting.
 *
 * @author Poojan Patel
 */
@Repository
public interface ParentQuestionRepository extends
		JpaRepository<ParentQuestion, Integer> {
}
