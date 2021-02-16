package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("life.xml");
		ctx.registerShutdownHook();// hey spring ple reg a callback when container shut down/finished ,
	
		MyBean bean=ctx.getBean("myBean", MyBean.class);
		bean.printBeanDetails();
		
		
//		A a=ctx.getBean("a", A.class);
//		a.logicA();
		
		
		//dont forget to call destroy method 
//		

//	
//		System.out.println("-------------");
//		YourBean bean2=ctx.getBean("yourBean", YourBean.class);
//		bean2.printBeanDetails();
		ctx.close();
	}
}
