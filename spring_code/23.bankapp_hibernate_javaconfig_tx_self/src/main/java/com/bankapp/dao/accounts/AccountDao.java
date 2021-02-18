package com.bankapp.dao.accounts;
import java.util.*;

import com.bankapp.entities.Account;
public interface AccountDao {
	public List<Account> getAllAccounts();
	public Account getById(int id);
	public void update(Account account);
	public void delete(int id);
	public void insert(Account account);
	
}
