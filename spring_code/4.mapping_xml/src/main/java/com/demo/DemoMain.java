package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		
		//Triangle triangle=ctx.getBean("tri", Triangle.class);
		//triangle.printTriangleDetails();
		
		Shape shape=ctx.getBean("sh", Shape.class);
		shape.printShapeDetails();
	}
}
