package com.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBean implements BeanNameAware, ApplicationContextAware , BeanClassLoaderAware{
	private String name;
	private Logger logger=LoggerFactory.getLogger(MyBean.class);
	
	public MyBean() {
		System.out.println("ctr of mybean is called...");
	}
	
	public void myInit() {
		System.out.println("init method of mybean is called xml wala");
	}
	
	@Override
	public void setBeanName(String name) {
		logger.info("bean name is configured:"+ name);
	}

	// service
	public void printBeanDetails() {
		System.out.println(name);
	}

	public void myDestroy() {
		System.out.println("destroy method of mybean is called xml wala");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyBean [name=" + name + "]";
	}

	//u can use this method to customized that particaular bean
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//u can get that bean and customized that 
		MyBean bean=(MyBean) applicationContext.getBean("myBean");
		
		this.name=bean.getName()+ " hello";
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		//u can use this class loade for further customization of that bean
		System.out.println(classLoader.getClass().getName());
	}

	

}
