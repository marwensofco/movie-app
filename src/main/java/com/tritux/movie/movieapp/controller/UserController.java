package com.tritux.movie.movieapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tritux.movie.movieapp.model.User;
import com.tritux.movie.movieapp.service.IUserService;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = { "http://localhost:4200", "*" })

public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	IUserService iUserService;

	/**
	 * The get method
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/findUser")
	public ResponseEntity<User> get() throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		logger.info("The userName is : {}", userName);
		User user = iUserService.getUser(userName);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}