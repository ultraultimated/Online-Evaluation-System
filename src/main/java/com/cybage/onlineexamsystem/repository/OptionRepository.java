/*
 * OptionsRepository
 *
 * Version information
 *
 * 10/26/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file OptionsRepository
 * Brief description of contents of file.
 * Long description
 * @date 11/12/2018
 */

package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author Poojan Patel
 */

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
}
