package com.gur.usuarios.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gur.usuarios.domain.User;
import com.gur.usuarios.dtos.UserDTO;

@Mapper
public interface UserMapper {

	@Mapping(source = "username", target = "username")
	@Mapping(source = "password", target = "password")
	@Mapping(source = "level", target = "level")
	User mapUserDtoToEntity(UserDTO request);
	
	@Mapping(source = "username", target = "username")
	@Mapping(source = "password", target = "password")
	@Mapping(source = "level", target = "level")
	UserDTO mapUserEntityToDTO(User user);
}
