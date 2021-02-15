package com.bookapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.UserDao;
import com.bookapp.model.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User findByUsername(String username){
		return userDao.findByUsername(username);
		
	}
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

}
