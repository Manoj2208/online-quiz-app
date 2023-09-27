package com.manu.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manu.userservice.Dto.UserDto;
import com.manu.userservice.response.ApiResponse;
import com.manu.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	ResponseEntity<ApiResponse> createUser(@RequestBody @Valid UserDto userDto) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDto));

	}
	
	@GetMapping("/{userId}")
	ResponseEntity<UserDto> getById(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUserById(userId));
	}

}
