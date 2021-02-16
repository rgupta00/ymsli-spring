package com.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext ctx2=new AnnotationConfigApplicationContext();
//		ctx2.registerShutdownHook();		
		
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("life2.xml");
		ctx.registerShutdownHook();
		MyBean bean=ctx.getBean("myBean", MyBean.class);
		bean.printBeanDetails();
		ctx.close();
	}
}
