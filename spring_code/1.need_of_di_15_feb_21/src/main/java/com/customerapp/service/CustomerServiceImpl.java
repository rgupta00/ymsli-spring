package com.customerapp.service;

import java.util.List;

import com.customerapp.dao.Customer;
import com.customerapp.dao.CustomerDao;
import com.customerapp.dao.CustomerDaoImplHib;
import com.customerapp.dao.DaoFactory;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao dao;
	private MessageService messageService;
	
	public CustomerServiceImpl(CustomerDao customerDao, MessageService messageService) {
		this.dao=customerDao;
		this.messageService=messageService;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
		messageService.sendMessage("raj@gmail.com", "u are registed");
	}

}
