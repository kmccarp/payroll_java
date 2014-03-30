package com.waffle.openpayroll;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {

	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getRequiredProperty("db.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));
		bean.setJpaProperties(hibernateProps());
		
		return bean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager mgr = new JpaTransactionManager();
		mgr.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return mgr;
	}
	
	private Properties hibernateProps() {
		Properties props = new Properties();
		props.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		props.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		return props;
	}
}
