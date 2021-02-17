package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle {
	@Value(value = "3")
	private String radius;

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}
	
	public void printCircle() {
		System.out.println(" i am a circle of radius :"+ radius);
	}
	
}
