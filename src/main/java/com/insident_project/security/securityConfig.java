package com.insident_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class securityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Gérer les utilisateurs selon la solution choisie (InMemory, DB, LDAP)
		
		PasswordEncoder pe = passwordEncoder();
		String mdp = pe.encode("emsi");
		System.out.println(mdp);
		auth.inMemoryAuthentication().withUser("user").password(mdp).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(mdp).roles("ADMIN");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Pour gérer l'accès aux URLs
		http.formLogin();
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/*").hasAnyRole("ADMIN","USER");
		http.authorizeRequests().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedPage("/403");
	
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
