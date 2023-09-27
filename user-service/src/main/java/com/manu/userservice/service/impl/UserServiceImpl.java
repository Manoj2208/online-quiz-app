package com.manu.userservice.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.manu.userservice.Dto.UserDto;
import com.manu.userservice.Entity.User;
import com.manu.userservice.exception.ResourceConflictExists;
import com.manu.userservice.exception.ResourceNotFound;
import com.manu.userservice.repository.UserRepository;
import com.manu.userservice.response.ApiResponse;
import com.manu.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ApiResponse createUser(UserDto userDto) {
		Optional<User> user = userRepository.findByEmail(userDto.getEmail());
		if (user.isPresent()) {
			throw new ResourceConflictExists(String.format("user with mail:%s already exists", userDto.getEmail()));
		}
		User user2 = new User();
		BeanUtils.copyProperties(userDto, user2);
		user2.setUserId(UUID.randomUUID().toString());
		userRepository.save(user2);
		return new ApiResponse("user created successfully", HttpStatus.OK);
	}

	@Override
	public UserDto getUserById(String id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound(String.format("user:%s not found", id)));
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto, user.getUserId());
		return userDto;
	}

}
