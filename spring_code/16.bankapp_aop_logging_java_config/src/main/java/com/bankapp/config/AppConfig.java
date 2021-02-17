package com.bankapp.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@EnableAspectJAutoProxy 
//@Import(DbConfig.class)
@ImportResource(value = {"dbconfig.xml"})
// let assume ur db config is perfectly defined in xml and u dont want to create java config for db
//u can ask java config to use that xml ie done by @ImportResource
public class AppConfig {

}
