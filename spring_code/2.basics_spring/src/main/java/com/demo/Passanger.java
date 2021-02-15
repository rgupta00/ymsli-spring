package com.demo;
//passanger has vehical : car bike

//Passanger -----> Vehical
//OCP

public class Passanger {
	private String name;
	private Integer age;
	private Vehical vehical;
	
	
	public Passanger() {	
		System.out.println("ctr is called");
	}
	public String getName() {
		return name;
	}
	
	public Passanger(String name, Integer age, Vehical vehical) {
		System.out.println("para ctr is called");
		this.name = name;
		this.age = age;
		this.vehical = vehical;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public Vehical getVehical() {
		return vehical;
	}
	public void setVehical(Vehical vehical) {
		
		this.vehical = vehical;
	}
	
	public void travel() {
		System.out.println("name: "+ name);
		System.out.println("age: "+ age);
		
		vehical.move();
	}
}
