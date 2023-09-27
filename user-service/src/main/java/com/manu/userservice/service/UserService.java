package com.manu.userservice.service;

import com.manu.userservice.Dto.UserDto;
import com.manu.userservice.response.ApiResponse;

public interface UserService {
	ApiResponse createUser(UserDto userDto);

	UserDto getUserById(String id);
}
