package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.config.MyConfig;

@SuppressWarnings("unused")
public class DemoMain {

	public static void main(String[] args) {
		
		
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("hello.xml");
	
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(MyConfig.class);
		
		Passanger passanger=(Passanger) ctx.getBean("p");
		
		passanger.travel();
		
	}
}
