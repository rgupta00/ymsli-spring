package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.config.AppConfig;


public class DemoMain {

	public static void main(String[] args) {
		
	
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Passanger passanger=(Passanger) ctx.getBean("passanger");
		//Passanger passanger2=(Passanger) ctx.getBean("passanger");
		
		passanger.travel();
		//System.out.println(passanger.hashCode());
		//System.out.println(passanger2.hashCode());
		
		
	}
}
