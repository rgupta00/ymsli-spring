package com.bookapp.model.dao;

import com.bookapp.model.entities.User;

public interface UserDao {
	public User findByUsername(String username);
	public void insert(User user);
}

