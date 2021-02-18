package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.Account;
import com.bankapp.entities.Record;
import com.bankapp.entities.TxStatus;
import com.bankapp.entities.TxType;
import com.bankapp.service.account.AccountService;
import com.bankapp.service.record.RecordService;
@Service(value = "bankFacade")
@Transactional(isolation = Isolation.READ_COMMITTED, 
propagation = Propagation.REQUIRED)
public class BankFacadeImpl implements BankFacade {

	private AccountService accountService;
	
	private RecordService recordService;

	@Autowired
	public BankFacadeImpl(AccountService accountService, RecordService recordService) {
		this.accountService = accountService;
		this.recordService = recordService;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@Override
	public Account getById(int id) {
		return accountService.getById(id);
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public void transfer(int fromId, int toId, double amount) {
		accountService.transfer(fromId, toId, amount);
		
		Record record=new Record(fromId, toId, amount, TxStatus.PENDING, "raj", TxType.TRANSFER);
		recordService.addRecord(record);
		//System.out.println(10/0);
	}

	@Override
	public void deposit(int accId, double amount) {
		accountService.deposit(accId, amount);
	}

	@Override
	public void withdraw(int accId, double amount) {
		accountService.withdraw(accId, amount);
	}

	@Override
	public void updateCustomerDetails(int id, String address, String phone, String email) {
		accountService.updateCustomerDetails(id, address, phone, email);
	}

	@Override
	public void delete(int id) {
		accountService.delete(id);
	}

	@Override
	public void insert(Account account) {
		accountService.insert(account);
	}

	@Override
	public List<Record> getAllRecords() {
		return recordService.getAllRecords();
	}

}
