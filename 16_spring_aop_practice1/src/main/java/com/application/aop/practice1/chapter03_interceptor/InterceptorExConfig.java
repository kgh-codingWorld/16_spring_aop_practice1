package com.application.aop.practice1.chapter03_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorExConfig implements WebMvcConfigurer {
	
	@Autowired
	private InterceptorEx interceptorEx;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptorEx)
		//.order(1)
		.addPathPatterns("/admin/*" , "/management/menu1");
		//.excludePathPatterns("/login" , "/register");
	}
}
