/*
 * UserRepository
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserRepository
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */
package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The UserRepository Interface provides access to database by using
 * spring-data-JPA
 * This interface implements CRUDrepository to provide basic functionality of
 * creating, retrieving, updating and deleting.
 *
 * @author {rahulpandy}
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

}
