package com.demo;

import org.springframework.stereotype.Component;

@Component
public class Foo {
	public String doFoo() {
		System.out.println("doing foo work...");
		return "rabbit form the hat";
	}
}
