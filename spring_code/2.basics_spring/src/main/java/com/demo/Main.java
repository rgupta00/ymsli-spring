package com.demo;

public class Main {

	public static void main(String[] args) {
		Vehical vehical=new Bike();
		Passanger passanger=new Passanger();
		//push
		passanger.setVehical(vehical);
		passanger.setName("rajesh");
		passanger.travel();
		
		
	}
}
