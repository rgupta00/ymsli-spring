package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/*
 * ctr of mybean is called.
 * init method of mybean is called InitializingBean wala
 * init method of mybean is called
 * 
 * ...
 * destroy method of mybean is called DisposableBean wala
 * destroy method of mybean is called
 * 
 */
public class MyBean implements InitializingBean,DisposableBean{
	private String name;

	public MyBean() {
		System.out.println("ctr of mybean is called...");
	}

	@PostConstruct
	public void myInitAnnotation() {
		System.out.println("init method of mybean is called annotation wala");
	}
	
	public void myInit() {
		System.out.println("init method of mybean is called xml wala");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method of mybean is called InitializingBean wala");
	}
	
	
	// service
	public void printBeanDetails() {
		System.out.println(name);
	}

	@PreDestroy
	public void myDestroyAnnotation() {
		System.out.println("destroy method of mybean is called Annotation wala");
	}
	
	
	public void myDestroy() {
		System.out.println("destroy method of mybean is called xml wala");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy method of mybean is called DisposableBean wala");
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyBean [name=" + name + "]";
	}

	
	

}
