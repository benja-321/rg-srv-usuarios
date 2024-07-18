package com.gur.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gur.usuarios.dtos.UserDTO;
import com.gur.usuarios.exception.UserConflictException;
import com.gur.usuarios.service.UserService;

@Controller("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Void> loginUser(String username, String password) throws UserConflictException {
		userService.validateUser(username, password);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(UserDTO request) throws UserConflictException {
		UserDTO response = userService.createUser(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
