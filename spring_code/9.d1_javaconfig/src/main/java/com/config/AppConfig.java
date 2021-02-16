package com.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.demo.Bike;
import com.demo.Car;
import com.demo.Passanger;
import com.demo.Vehical;

@Configuration //hey spring this class is used to provide confi bean to you ie its a replament of xml
@ComponentScan(basePackages = {"com.demo"})// go inside this pacakge and u will find ann meta data
public class AppConfig {

	//then spring will register the bean with the method name "getPassanger"
	//@Scope(scopeName = "prototype")
	
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	
	@Bean(name = "passanger", autowire = Autowire.BY_NAME,autowireCandidate = true)
	public Passanger getPassanger() {
		Passanger passanger=new Passanger();
		passanger.setName("raj");
		passanger.setAge(32);
		//passanger.setVehical(getVehical());
		return passanger;
	}
	
	//@Primary
	@Bean(name = "vehical")
	public Vehical getBike() {
		return new Bike();
	}
	
	//@Primary
	@Bean(name = "vehical1")
	public Vehical getCar() {
		return new Car();
	}
	
	
}
