package com.bankapp.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class DbConfig {

	@Value("${jdbc.driver}")
	private String driverName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.initpoolsize}")
	private Integer initialSize;
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverName);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(initialSize);
		return ds;
	}
	
}
