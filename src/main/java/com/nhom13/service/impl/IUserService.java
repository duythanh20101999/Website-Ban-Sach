package com.nhom13.service.impl;

import java.util.Optional;

import com.nhom13.model.User;

public interface IUserService {
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	Boolean existsByPhone(String phone);
	
	Optional<User> findByEmail(String email);
	
	User save(User user);
	
	
}
