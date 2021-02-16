package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("demo.xml");
		Passanger passanger=ctx.getBean("p", Passanger.class);
		passanger.travel();
		
		
//		Vehical vehical=new Bike();
//		Passanger passanger=new Passanger();
//		passanger.setAge(39);
//		passanger.setName("raj");
//		passanger.setVehical(vehical);
//		passanger.travel();
	
		
	}
}
