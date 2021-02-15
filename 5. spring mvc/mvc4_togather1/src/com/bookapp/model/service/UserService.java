package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.persistance.User;

public interface UserService {
	public User getUser(String email, String password);
	public void addUser(User user);
	public List<User> getAllUser();
}
