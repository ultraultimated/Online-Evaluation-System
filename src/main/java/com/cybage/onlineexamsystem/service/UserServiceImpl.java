/*
 * UserServiceImpl
 *
 * Version information
 *
 * 10/31/2018
 *
 * Copyright (c) 2018 Cybage software Pvt. Ltd. All rights reserved
 */

/**
 * @file UserServiceImpl
 * Brief description of contents of file.
 * Long description
 * @date 10/31/2018
 */


package com.cybage.onlineexamsystem.service;

import com.cybage.onlineexamsystem.exceptions.UserNotFoundException;
import com.cybage.onlineexamsystem.model.User;
import com.cybage.onlineexamsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The Example class provides ...
 *
 * @author {rahulpandy}
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	/**
	 * @param user object with values to save in database
	 */
	public void addUser(User user) {
		userRepository.save(user);
	}

	/**
	 * @return List of all users.
	 */
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * @param id to find User
	 * @return Object of User
	 * @throws UserNotFoundException if user id does not exist
	 */
	@Override
	public User getUserById(int id) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(id);
		if( optional.isPresent() ) {

			return optional.get();
		} else {
			throw new UserNotFoundException();
		}
	}

	/**
	 * @param username to find User
	 * @return user object
	 * @throws UserNotFoundException if user id does not exist
	 */
	@Override
	public User getUserByUsername(String username) throws UserNotFoundException {
		Optional<User> optional = userRepository.findByUsername(username);
		if( optional.isPresent() ) {
			return optional.get();
		} else {
			throw new UserNotFoundException();
		}
	}

	/**
	 * @param username to find
	 * @return true or false if user exists or not
	 */
	@Override
	public boolean checkUniqueUserName(String username) {
		Optional<User> optional = userRepository.findByUsername(username);
		return ! optional.isPresent();
	}

//	@Override
//	public User authenticateUser(String Username, String password) {
//
//
//		if(optional.isPresent())
//		{
//			return optional.get();
//		}else
//		{
//			return null;
//		}
//	}
}

