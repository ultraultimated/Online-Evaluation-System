package com.cybage.onlineexamsystem.controller;

import com.cybage.onlineexamsystem.model.User;
import com.cybage.onlineexamsystem.security.JwtGenerator;

import com.cybage.onlineexamsystem.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by neelp on 11/16/2018.
 */
@RestController
@RequestMapping("/token")
public class TokenController {
	@Autowired
	private UserServiceImpl userService;
	private JwtGenerator jwtGenerator;
	Logger logger = LoggerFactory.getLogger("info");

	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@PostMapping("/generate")
	public String generate(@RequestBody final User jwtUser) {
		int response = userService.getUserType(jwtUser.getUsername(),
		                                      jwtUser.getPassword(),
		                                      jwtUser.getUserType());
		logger.info("response"+response);
		if(response == 1){
			logger.info("token generated");
			return jwtGenerator.generate(jwtUser);
		}
		else
		{
			return null;
	}

}

}