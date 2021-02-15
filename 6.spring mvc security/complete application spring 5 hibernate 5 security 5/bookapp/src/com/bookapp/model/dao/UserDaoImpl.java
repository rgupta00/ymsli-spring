package com.bookapp.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapp.model.entities.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public User findByUsername(String username){
		Query query = openSession().createQuery("from User u where u.username = :username");
		query.setParameter("username", username);
		List<User>userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}

	public void insert(User user){
		openSession().save(user);
	}
}