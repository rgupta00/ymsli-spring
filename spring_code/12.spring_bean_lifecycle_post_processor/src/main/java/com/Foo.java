package com;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo {
	private String fooVal;

	public Foo() {
		System.out.println("foo ctr is called");
	}
	
	//life cycle method should take param/ should not retun anything ... error
	@PostConstruct
	public void init() {
		System.out.println("my init method using @PostConstruct anno");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("my destory method using @PreDestroy anno");
	}
	
	public String getFooVal() {
		return fooVal;
	}

	public void setFooVal(String fooVal) {
		this.fooVal = fooVal;
	}

	@Override
	public String toString() {
		return "Foo [fooVal=" + fooVal + "]";
	}
	
	
}
