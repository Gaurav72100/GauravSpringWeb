package com.springmvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages="com.springmvc")
public class SpringConfig implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/gk");
		datasource.setUsername("root");
		datasource.setPassword("578038");
		
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource(dataSource());
		sessionfactory.setPackagesToScan("com.springmvc.model");//here also use class name with package
		
		Properties hibernateprop = new Properties();
		
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateprop.put("hibernate.show_sql", "true");
		hibernateprop.put("hibernate.hbm2ddl.auto", "update");
	    sessionfactory.setHibernateProperties(hibernateprop);
	    
	    return sessionfactory;
			
	}
	
	@Bean
	  public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}
