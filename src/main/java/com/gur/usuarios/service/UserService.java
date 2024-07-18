package com.gur.usuarios.service;

import com.gur.usuarios.dtos.UserDTO;
import com.gur.usuarios.exception.UserConflictException;
import com.gur.usuarios.exception.UserNotFoundException;

public interface UserService {

	UserDTO createUser(UserDTO userRequest) throws UserConflictException;
	
	UserDTO getUser(String username) throws UserNotFoundException;
	
	void validateUser(String username, String password) throws UserConflictException;
	
	void changePassword(String username, String oldPassword, String newPassword);
	
	void updateLevel(String username, Integer level);
	
	void deleteUser(String name);
}
