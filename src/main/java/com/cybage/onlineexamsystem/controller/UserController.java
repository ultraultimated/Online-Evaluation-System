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
 * Long description
 * @date 10/31/2018
 */

package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.exceptions.UserNotFoundException;
import com.cybage.onlineexamsystem.model.User;
import com.cybage.onlineexamsystem.model.dto.CategoryDTO;
import com.cybage.onlineexamsystem.model.dto.UserDTO;
import com.cybage.onlineexamsystem.service.UserServiceImpl;
import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;


/**
 * The Example class provides ...
 *
 * @author {rahulpandy}
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param user insert
     */
    @PostMapping("/insert")
    private void insertuser(@RequestBody User user) {
        user.setPassword(Base64.encodeBase64String(user.getPassword().getBytes()));
        userService.addUser(user);
    }

    /**
     * @return all users
     */
    @GetMapping("/all")
    private List getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * @param id User Id to be found
     * @return User related to the id
     */
    @GetMapping("/id/{id}")
    private User getUserById(
            @PathVariable int id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    /**
     * @param username to be found
     * @return User related to the username
     */
    @GetMapping("/name/{username}")
    private User getUserByUsername(
            @PathVariable String username) throws UserNotFoundException {
        return userService.getUserByUsername(username);
    }

    /**
     * @param username to be found
     * @return false if user exits and true if it does not exist
     */
    @GetMapping("/name/exists/{username}")
    private boolean checkUniqueUserName(@PathVariable String username) {
        return userService.checkUniqueUserName(username);
    }

    /**
     * @param userId
     * @return userId, username and userType for a given userId
     * @throws UserNotFoundException
     */
    @GetMapping("/userdto/id/{userId}")
    private UserDTO getUsernameByUserId(@PathVariable int userId) throws UserNotFoundException{
        Type user = new TypeToken<UserDTO>() {
        }.getType();
        return modelMapper.map(userService.getUserById(userId), user);

    }



}
