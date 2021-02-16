package com.demo;

public class A {
	A(){
		System.out.println("ctr of A");
	}
	private B b;
	
	public void myInit() {
		System.out.println("myInit of A");
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		System.out.println("setB is called");
		this.b = b;
	}
	
	public void logicA() {
		System.out.println("logic of A");
		b.logicB();
	}
	
	public void myDestroy() {
		System.out.println("myDestroy of A");
	}
	
}
