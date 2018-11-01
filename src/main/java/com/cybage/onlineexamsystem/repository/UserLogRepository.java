/*
 * UserLogRepository
 *
 * Version information
 *
 * 11/1/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserLogRepository
 * Brief description of contents of file.
 * Long description
 * @date 11/1/2018
 */
package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Example interface provides ...
 *
 * @author {neelp}
 */

@Repository
public interface UserLogRepository extends JpaRepository<Log, Integer> {
	List<Log> getAllByUserId(int userId);
}
