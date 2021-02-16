package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("unused")
public class DemoMain {
	private static Logger logger=LoggerFactory.getLogger(DemoMain.class);
	public static void main(String[] args) {
		
		logger.info("hello");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("hello.xml");
	
		Passanger passanger=(Passanger) ctx.getBean("p");
		
		passanger.travel();
		
	}
}
