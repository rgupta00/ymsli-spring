package com.customerapp.dao;

import java.util.List;

public class CustomerDaoImplHib implements CustomerDao{

	@Override
	public List<Customer> getAllCustomers() {
		System.out.println("logic for getting all customers using hib");
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		System.out.println("logic for adding customer using hib");
	}

}
