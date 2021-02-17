package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Rectangle {
	@Value(value = "30")
	private int l;
	@Value(value = "3")
	private int b;

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public void printSquare() {
		System.out.println("i am a reatangle");
		System.out.println("l:"+ l +" b: "+ b);
	}
}
