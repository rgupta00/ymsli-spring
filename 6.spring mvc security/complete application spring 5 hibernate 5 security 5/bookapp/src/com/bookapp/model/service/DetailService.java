package com.bookapp.model.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.entities.User;
@Service
@Transactional
public class DetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	//@PostConstruct
	public void post(){
		User user1=new User("raj", "raj", "raj.mtech@gmail.com", true, new String[]{"ROLE_EMP", "ROLE_MGR","ROLE_ADMIN"});
		User user2=new User("eku", "eku", "eku.mtech@gmail.com", true, new String[]{"ROLE_MGR","ROLE_EMP"});
		User user3=new User("gun", "gun", "raj.mtech@gmail.com", true, new String[]{"ROLE_EMP"});
		
		System.out.println("inserting an default user");
		userService.insert(user1);
		userService.insert(user2);
		userService.insert(user3);
	}
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		User user=userService.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("username is not found");
		return new org.springframework.security.core.userdetails.User(user.getUsername()
				,user.getPassword(),AuthorityUtils.createAuthorityList(user.getRoles()));
	}
}