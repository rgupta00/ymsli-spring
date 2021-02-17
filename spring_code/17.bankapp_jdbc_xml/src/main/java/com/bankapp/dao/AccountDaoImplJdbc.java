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
import org.springframework.stereotype.Repository;
@Repository
//@Primary
public class AccountDaoImplJdbc implements AccountDao {

	private DataSource dataSource;
	
	@Autowired
	public AccountDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> getAllAccounts() {
		Account account=null;
		
		List<Account> accounts=new ArrayList<Account>();
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		try {
			 connection=dataSource.getConnection();
			 pstmt=connection
					.prepareStatement("select * from account2");
			ResultSet rs=pstmt.executeQuery();
			// id | name   | balance | address | phone     | email       
			while(rs.next()) {
				account=new Account
						(rs.getInt(1), 
							rs.getString(2),
							rs.getDouble(3), 
							rs.getString(4), 
							rs.getString(5), 
							rs.getString(6));
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// close rs, ps : what the hell :(
		}
		return accounts;
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
