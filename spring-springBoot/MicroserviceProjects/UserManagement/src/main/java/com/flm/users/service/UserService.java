package com.flm.users.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.flm.users.builder.UserBuilder;
import com.flm.users.dao.UserRespository;
import com.flm.users.dto.request.UserCreateRequest;
import com.flm.users.dto.request.UserUpdateRequest;
import com.flm.users.dto.response.UserResponse;
import com.flm.users.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRespository userRespository;
	
	@Autowired
	Environment env;
	
	public UserResponse save(UserCreateRequest userCreateRequest) {
		
		User user = UserBuilder.buildUserFromUserCreateRequest(userCreateRequest);
		
		User savedUser = userRespository.save(user);
		
		UserResponse userResponse = UserBuilder.buildUserResponseFromUser(savedUser);
		
		return userResponse;
		
	}
	
	public List<UserResponse> getAllUsers() {
		
		return userRespository
			.findAll()
			.stream()
			.map(UserBuilder::buildUserResponseFromUser)
			.toList();
		
	}
	
	public UserResponse getUserById(long userId) {
		
		User user = userRespository
			.findById(userId)
			.orElseThrow(() -> new RuntimeException("User not found with id : " + userId));
		
		UserResponse userResponse = UserBuilder.buildUserResponseFromUser(user);
		
		String port = env.getProperty("local.server.port");
		userResponse.setUserName(userResponse.getUserName()+ " " + port);
		return userResponse;
		
	}
	
	public UserResponse update(long userId, UserUpdateRequest userUpdateRequest) {
		
		User existingUser = userRespository
			.findById(userId)
			.orElseThrow(() -> new RuntimeException("User not found with id : " + userId));
		
		User user = UserBuilder.buildUserFromUserUpdateRequest(existingUser, userUpdateRequest);
		
		User savedUser = userRespository.save(user);
		
		return UserBuilder.buildUserResponseFromUser(savedUser);
		
	}
	
	public void delete(long userId) {
		
		if (!userRespository.existsById(userId)) {
			throw new RuntimeException("User not found with id : " + userId);
		}
		
		userRespository.deleteById(userId);
		
	}
	
}
