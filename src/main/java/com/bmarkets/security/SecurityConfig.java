package com.bmarkets.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//use inmemory authentication to sign in 
		auth.inMemoryAuthentication().withUser("Moncef.NSIRI").password("{noop}1234").roles("ADMIN","SIMPLEUSER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/viewAccount","/operations").hasRole("SIMPLEUSER");
		http.authorizeRequests().antMatchers("/saveOperations").hasRole("ADMIN");
	}
}
