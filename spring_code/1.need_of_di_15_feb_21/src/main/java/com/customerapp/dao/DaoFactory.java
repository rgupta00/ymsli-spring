package com.customerapp.dao;

public class DaoFactory {

	public static CustomerDao getCustomerDao() {
		return new CustomerDaoImplHib();
	}
}
