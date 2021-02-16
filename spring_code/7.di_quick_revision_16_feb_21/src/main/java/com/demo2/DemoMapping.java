package com.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMapping {

	public static void main(String[] args) {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("account.xml");
		
		Bank bank=ctx.getBean("bank", Bank.class);
		bank.printBankDetails();
	}
}
