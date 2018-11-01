/*
 * UserController
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file CategoryController
 * Brief description of contents of file.
 * <p>
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.UserNotFoundException;
import com.cybage.onlineexamsystem.model.User;
import com.cybage.onlineexamsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The Example class provides ...

 @author {rahulpandy}
 @version
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     *
     * @param user
     */
    @PostMapping("/add")
    private void insertuser(@RequestBody User user)
    {
        userService.addUser(user);
    }

    /**
     *
     * @return all users
     */
    @GetMapping("/all")
    private List getAllUsers(){

        return userService.getAllUsers();
    }

    /**
     *
     * @param id User Id to be found
     * @return User relaetd to the id
     */
    @GetMapping("/{id}")
    private User getUserById(@PathVariable int id) throws UserNotFoundException
    {
        return userService.getUserById(id);
    }

    /**
     *
     * @param username to be found
     * @return User relaetd to the username
     */
    @GetMapping("/{username}/get")
    private User getUserByUsername(@PathVariable String username) throws UserNotFoundException
    {
        return userService.getUserByUsername(username);
    }
}
