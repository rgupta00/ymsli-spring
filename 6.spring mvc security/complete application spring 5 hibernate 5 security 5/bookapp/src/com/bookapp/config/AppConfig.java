package com.bookapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslationInterceptor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bookapp.model" })
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource(value="classpath:db.properties")
public class AppConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {

		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDataSource());
		lsfb.setPackagesToScan("com.bookapp.model.entities");
		lsfb.setHibernateProperties(getHibernateProperties());
		return lsfb;

	}

	private DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(environment.getProperty("driver"));
		ds.setUrl(environment.getProperty("url"));
		ds.setPassword(environment.getProperty("password"));
		ds.setUsername(environment.getProperty("username"));
		return ds;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.formate_sql", "true");
		return properties;
	}

	@Bean
	public PersistenceExceptionTranslationInterceptor getPersistenceExceptionTranslationInterceptor() {
		return new PersistenceExceptionTranslationInterceptor();
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) {
		HibernateTransactionManager tmx = new HibernateTransactionManager();
		tmx.setSessionFactory(factory);
		return tmx;
	}
}
