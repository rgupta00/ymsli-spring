package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoImplJdbc implements AccountDao {

	private DataSource dataSource;
	
	@Autowired
	public AccountDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> getAllAccounts() {
		return null;
	}

	@Override
	public Account getById(int id) {
		return null;
	}

	@Override
	public void update(Account account) {
		
	}

	@Override
	public void delete(int id) {
		
	}
	//id name,balance,address,phone, email
	@Override
	public void insert(Account account) {
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement pstmt=
					connection.prepareStatement
					("insert into account2(name,balance,address,phone, email) values (?,?,?,?,?)");
			pstmt.setString(1, account.getName());
			pstmt.setDouble(2, account.getBalance());
			pstmt.setString(3, account.getAddress());
			pstmt.setString(4, account.getPhone());
			pstmt.setString(5, account.getEmail());
			pstmt.executeUpdate();
			
			System.out.println("----inserted....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
