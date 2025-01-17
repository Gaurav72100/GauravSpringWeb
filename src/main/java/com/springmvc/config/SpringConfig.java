package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;




@EnableWebMvc
@ComponentScan(basePackages="com.springmvc")
public class SpringConfig implements WebMvcConfigurer {
	
	
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolve = new InternalResourceViewResolver();
		
		resolve.setViewClass(JstlView.class);
		resolve.setPrefix("/WEB-INF/jsp/");
		resolve.setSuffix(".jsp");
		
		return resolve;
	}

}