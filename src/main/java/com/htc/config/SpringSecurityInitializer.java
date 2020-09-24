package com.htc.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer  {
	//This is to load and initialize 'springSecurityFilterChain'
	
	//no code here..
	static {
		System.out.println("loading springsecurity filter chain");
	}
}
