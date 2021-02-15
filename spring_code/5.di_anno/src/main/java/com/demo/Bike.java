package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
//@Component(value = "bike")
public class Bike implements Vehical {
	@Override
	public void move() {
		System.out.println("moving on a bike");
	}
}