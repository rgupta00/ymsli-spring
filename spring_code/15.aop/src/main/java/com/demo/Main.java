package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop.xml");
		
		CircleClient circleClient=ctx.getBean("circleClient",CircleClient.class);
		circleClient.doCircleLogic(new Circle());
		
		circleClient.doCircleLogic(new Circle());
		
		
//		Rectangle rectangle=ctx.getBean("rectangle", Rectangle.class);
//		System.out.println(rectangle.getB());
//		rectangle.printSquare();
//		
//		Circle circle=ctx.getBean("circle", Circle.class);
//		System.out.println(circle.getRadius());
		
//		Magician magician=(Magician) ctx.getBean("magician");
//		magician.doMagic();
//		magician.doEat("south indian food");
//		
//		Foo foo=ctx.getBean("foo", Foo.class);
//		foo.doFoo();
		//System.out.println(value);
	}

}
