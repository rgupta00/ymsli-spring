package com.customerapp.dao;

import java.util.List;

public class CustomerDaoImplJdbc implements CustomerDao{

	@Override
	public List<Customer> getAllCustomers() {
		System.out.println("logic for getting all customers using jdbc");
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		System.out.println("logic for adding customer using jdbc");
	}

}
