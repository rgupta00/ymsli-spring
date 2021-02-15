package com.bookapp.web.controllers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.config.AppConfig;

public class Tester {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
	}

}
