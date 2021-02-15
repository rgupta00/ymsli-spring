package com.customerapp.dao;
import java.util.*;
public interface CustomerDao {
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
}
