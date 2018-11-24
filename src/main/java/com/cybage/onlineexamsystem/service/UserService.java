/*
 * UserService
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserService
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.UserNotFoundException;
import com.cybage.onlineexamsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The CategoryService  interface provides all the methods that are utilized
 * on category.
 *
 * @author {rahulpandy}
 */
@Service
public interface UserService {

    /**
     * @param user User object to insert in the database
     */
    void addUser(User user);

    /**
     * @return List of all Users in table category.
     */
    List<User> getAllUsers();

    /**
     * @param id to find User
     * @return User for a particular ID.
     */
    User getUserById(int id) throws UserNotFoundException;

    /**
     * @param username to find User
     * @return User for a particular Username.
     */
    User getUserByUsername(String username) throws
            UserNotFoundException;

    /**
     * @param username username to check
     * @return true/false based on database
     */
    boolean checkUniqueUserName(String username);

//	public User authenticateUser(String Username, String password);

}
