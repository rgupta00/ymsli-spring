package com.bookapp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages={"com.bookapp.security.config"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService detailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("EMP","ADMIN","MGR")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/mgr/**").hasRole("MGR")
		/*.anyRequest().authenticated()*/
		.and()
		.formLogin()
			.loginPage("/showLoginPage")//url pattern of controller that display login page
			.loginProcessingUrl("/authTheUser")
			.permitAll()
		.and()
			.logout().permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/access_denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailService).passwordEncoder(com.bookapp.model.entities.User.encode);
		
	}
	
	
//	
}






