package com.bookapp.model.persistance;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.source.annotations.entity.EmbeddableClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory factroy;

	public Session getSession() {
		return factroy.getCurrentSession();
	}
	//?
	@Override
	public User getUser(String email, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = getSession()
				.createQuery(
						"select u from User u where u.email =:email and u.password=:password")
				.setString("email", email).setString("password", password)
				.list();
		if (users.size() > 0)
			return users.get(0);
		else
			throw new UserNotFoundException("user with email " + email
					+ "not found");
	}

	@Override
	public void addUser(User user) {
		getSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		return getSession().createQuery("from User").list();
	}

}
