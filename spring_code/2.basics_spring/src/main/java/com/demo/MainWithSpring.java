package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithSpring {

	public static void main(String[] args) {
		//bean wiring: xml
//		Passanger passanger=hey spring give me the passanger object
//				dont forget to add(push) vehical to that
//		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("hello.xml");
		System.out.println("--------------");
//		Passanger passanger=(Passanger) ctx.getBean("p");
//		System.out.println(passanger.hashCode());
//		passanger.travel();
//		
//		Passanger passanger2=(Passanger) ctx.getBean("p");
//		System.out.println(passanger2.hashCode());
//		
		
		
	}
}
