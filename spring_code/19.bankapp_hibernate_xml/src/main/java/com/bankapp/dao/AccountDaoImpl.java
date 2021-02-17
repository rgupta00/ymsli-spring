package com.bankapp.dao;

import java.util.*;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
//@Primary
public class AccountDaoImpl implements AccountDao{

	private Map<Integer, Account>accounts=new HashMap<>();
	private static int counter=2;
	
	public AccountDaoImpl() {
		accounts.put(1, new Account(1, "raj", 1000,"delhi","45345454545","raj@gmail.com"));
		accounts.put(2, new Account(2, "ekta", 1000,"delhi","45045454545","ekta@gmail.com"));
		
	}
	@Override
	public List<Account> getAllAccounts() {
		return new ArrayList<Account>(accounts.values());
	}

	@Override
	public Account getById(int id) {
		return accounts.get(id);
	}

	@Override
	public void update(Account account) {
		accounts.put(account.getId(), account);
	}

	@Override
	public void delete(int id) {
		accounts.remove(id);
	}

	@Override
	public void insert(Account account) {
		++counter;
		account.setId(counter);
		accounts.put(counter, account);
	}

}
