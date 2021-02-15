package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.persistance.User;
import com.bookapp.model.persistance.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String email, String password) {
		return userDao.getUser(email, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}
