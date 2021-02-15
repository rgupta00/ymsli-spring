package com.customerapp.service;

import java.util.List;

import com.customerapp.dao.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
}
