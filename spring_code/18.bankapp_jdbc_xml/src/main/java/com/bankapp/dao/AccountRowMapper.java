package com.bankapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account>{
	// 			spring will pick one row and call this method ...till row not finished...
	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account=new Account
				(rs.getInt(1), 
						rs.getString(2),
						rs.getDouble(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6));
		//System.out.println("------account rowmaper is called-------"+ rowNum);
		return account;
	}

}
