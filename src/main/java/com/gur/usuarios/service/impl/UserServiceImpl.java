package com.gur.usuarios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gur.usuarios.domain.User;
import com.gur.usuarios.dtos.UserDTO;
import com.gur.usuarios.exception.UserConflictException;
import com.gur.usuarios.exception.UserNotFoundException;
import com.gur.usuarios.mapper.UserMapper;
import com.gur.usuarios.repository.UserRepository;
import com.gur.usuarios.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDTO createUser(UserDTO userRequest) throws UserConflictException {
		boolean userExists = userRepository.existsById(userRequest.getUsername());
		if(userExists) {
			throw new UserConflictException(String.format("User %s already exists", userRequest));
		}
		User userSaved = userRepository.save(userMapper.mapUserDtoToEntity(userRequest));
		return userMapper.mapUserEntityToDTO(userSaved);
	}

	@Override
	public UserDTO getUser(String username) throws UserNotFoundException {
		Optional<User> optUser = userRepository.findById(username);
		if(optUser.isPresent()) {
			return userMapper.mapUserEntityToDTO(optUser.get());
		} else {
			throw new UserNotFoundException(String.format("User %s not found", username));
		}
	}

	@Override
	public void changePassword(String username, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLevel(String username, Integer level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateUser(String username, String password) throws UserConflictException {
		Optional<User> optUser = userRepository.findById(username);
		if(optUser.isEmpty() || !optUser.get().getPassword().equals(password)) {
			throw new UserConflictException(String.format("Fail to validate user %s", username));
		}
	}

	
}
