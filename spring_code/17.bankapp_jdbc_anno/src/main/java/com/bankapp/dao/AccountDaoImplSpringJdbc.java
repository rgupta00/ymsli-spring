package com.bankapp.dao;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoImplSpringJdbc implements AccountDao {

	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDaoImplSpringJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAllAccounts() {
		return jdbcTemplate.query("select * from account2", new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject("select * from account2 where id=?", 
				new AccountRowMapper(), id);
	}

	@Override
	public void update(Account account) {
		//id | name   | balance | address | phone     | email   
		String query="update account2 set balance=?, address=?, phone=?, email=? where id=?";
		jdbcTemplate.update(query, 
				new Object[] {
						account.getBalance(), 
						account.getAddress(), 
						account.getPhone(),
						account.getEmail(),
						account.getId()});
	}

	@Override
	public void delete(int id) {
		
		String query="delete from account2 where id=?";
		jdbcTemplate.update(query, new Object[] {id});
		
	}
	//id name,balance,address,phone, email
	@Override
	public void insert(Account account) {
		String query="insert into account2(name,balance,address,phone, email) values (?,?,?,?,?)";
		jdbcTemplate.update(query, 
				new Object[] {
				account.getName(),
				account.getBalance(), 
				account.getAddress(), 
				account.getPhone(),
				account.getEmail()});
	}

}
