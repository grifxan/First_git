package com.htc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;

 /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("htcuser").password("123Welcome").roles("USER");
        auth.inMemoryAuthentication().withUser("newuser").password("welcome").roles("USER","EDITOR");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER","EDITOR","ADMIN");
    }	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        	.anyRequest().authenticated()
	        	.and().httpBasic();
	                
	    } */

	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled from users where username=?")
								.authoritiesByUsernameQuery("select username,role from user_roles where username=?");
    }	


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/login").permitAll()
          .antMatchers("/list").hasRole("ADMIN")
          .antMatchers("/contactform").hasRole("EDITOR")
          .antMatchers("/searchContactForm").hasRole("USER")      
          .antMatchers("/deleteContact/*").hasRole("ADMIN")
          .and()
          	.formLogin()       
          	.usernameParameter("username")
          	.passwordParameter("password")
          	.defaultSuccessUrl("/index")
          	.failureUrl("/login?error")
          .and()
          	.logout().logoutSuccessUrl("/login?logout")
          .and()
          	.exceptionHandling().accessDeniedPage("/Access_Denied");        
    }
    
    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
