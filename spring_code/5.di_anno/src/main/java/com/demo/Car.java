package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
//@Component(value = "car")
public class Car implements Vehical {
	@Override
	public void move() {
		System.out.println("moving in a car");
	}
}