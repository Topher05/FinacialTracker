package com.financialTracker.FT.mapper;

import org.mapstruct.Mapper;

import com.financialTracker.FT.dto.CreateUserDTO;
import com.financialTracker.FT.dto.UserDTO;
import com.financialTracker.FT.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	User convertToUser(UserDTO userDTO);
	User convertToUser(CreateUserDTO createUserDTO);
	UserDTO convertToUserDTO(User user);
	

}
