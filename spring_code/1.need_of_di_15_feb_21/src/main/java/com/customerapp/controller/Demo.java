package com.customerapp.controller;
import java.util.*;

import com.customerapp.dao.Customer;
import com.customerapp.dao.CustomerDao;
import com.customerapp.dao.CustomerDaoImplHib;
import com.customerapp.service.CustomerService;
import com.customerapp.service.CustomerServiceImpl;
import com.customerapp.service.MessageService;
import com.customerapp.service.SmsService;

public class Demo {

	public static void main(String[] args) {
		
		
		//List<Customer> customers=customerService.getAllCustomers();
		MessageService messageService=new SmsService();
		CustomerDao customerDao=new CustomerDaoImplHib();
		
		//u are pushing the dep, NPEx
		// we wish rather then i m creating and pushing the dep , somebody will come 
		//and magically push the dependencies which my CustomerService...
		// i can achive loose coupling
		// spring can do that: spring can push the dependencies
		
		//DI: hollywood pri..."dont call me i will call u"
		/*
		 * constructor injection
		 * 
		 * setter inj
		 * 
		 * field inj:
		 *
		 **/
		
		CustomerService customerService=new CustomerServiceImpl(customerDao, messageService);
		
		Customer customer=new Customer();
		customerService.addCustomer(customer);
		
	}
}
