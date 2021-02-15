package com.bankapp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bank.xml");
		
		AccountService accountService=applicationContext.getBean("as", AccountService.class);
		accountService.transfer(1, 2, 100);
		
		System.out.println(accountService.getById(1));
		System.out.println(accountService.getById(2));
		
	}
}
