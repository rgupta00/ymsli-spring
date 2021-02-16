package com.demo;

public class B {
	B(){
		System.out.println("ctr of B");
	}
	public void myInit() {
		System.out.println("myInit of B");
	}
	
	public void logicB() {
		System.out.println("logic of B");
	}
	public void myDestroy() {
		System.out.println("myDestroy of B");
	}
}
