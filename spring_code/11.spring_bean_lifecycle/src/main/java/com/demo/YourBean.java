package com.demo;

public class YourBean {
	private String name;

	public YourBean() {
		System.out.println("ctr of yourbean is called...");
	}

	public void myInit() {
		System.out.println("init method of yourbean is called");
	}

	// service
	public void printBeanDetails() {
		System.out.println(name);
	}

	public void myDestroy() {
		System.out.println("destroy method of yourbean is called");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "yourbean [name=" + name + "]";
	}

}
