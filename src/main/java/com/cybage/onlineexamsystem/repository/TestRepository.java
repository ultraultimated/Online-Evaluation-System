/*
 * TestRepository
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file TestRepository
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */
package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.exceptions.TestNotFoundException;
import com.cybage.onlineexamsystem.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The Example interface provides ...

 @author {neelp}
 @version
 */
public interface TestRepository extends JpaRepository<Test, Integer>
{
	public List<Test> findAllBySubcategoryId(int subCategroyId) throws TestNotFoundException;
}
