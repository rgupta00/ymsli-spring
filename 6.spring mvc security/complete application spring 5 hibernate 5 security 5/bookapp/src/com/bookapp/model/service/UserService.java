package com.bookapp.model.service;

import com.bookapp.model.entities.User;

public interface UserService {
	public User findByUsername(String username);
	public void insert(User user);
}
