package com.financialTracker.FT.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financialTracker.FT.dto.CreateUserDTO;
import com.financialTracker.FT.dto.UserDTO;
import com.financialTracker.FT.exception.ResourceNotFoundException;
import com.financialTracker.FT.mapper.UserMapper;
import com.financialTracker.FT.model.User;
import com.financialTracker.FT.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepo;
	private final UserMapper userMapper;
	
	public UserDTO getUserById(long id) { 
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isEmpty()) {
			throw new ResourceNotFoundException("No User Foud with id = " + id);
		}
		User user = optionalUser.get();
		return userMapper.convertToUserDTO(user);
	}
	
	public UserDTO createUser(CreateUserDTO createUserDTO) {
		User userToSave = userMapper.convertToUser(createUserDTO);
		
		User savedUser = userRepo.save(userToSave);
		return userMapper.convertToUserDTO(savedUser);
	}
}
