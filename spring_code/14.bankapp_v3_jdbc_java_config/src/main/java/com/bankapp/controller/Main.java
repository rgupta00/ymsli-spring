package com.bankapp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.config.AppConfig2;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		//ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bank.xml");
		
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(AppConfig2.class);
		
		AccountService accountService=applicationContext.getBean("as", AccountService.class);
		
		Account account=new Account("keshav", 2000, "delhi", "454545545", "keshav@gmail.com");
		//Account account2=new Account("suman", 2000, "delhi", "454545545", "suman@gmail.com");
		
		accountService.insert(account);
		//accountService.insert(account);
		
//		accountService.transfer(1, 2, 100);
//		
//		System.out.println(accountService.getById(1));
//		System.out.println(accountService.getById(2));
		
	}
}
