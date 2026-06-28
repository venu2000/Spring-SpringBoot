package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement      // to enable @Transactional 
public class Config {
	
	
	@Bean
	public DataSource dataSource() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Venu@1526");
		return dataSource;
		
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com");
		sessionFactory.setHibernateProperties(hiberProperties());
		return sessionFactory;

	}
	
	@Bean
	public Properties hiberProperties() {
		Properties props = new Properties();
	    props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    props.put("hibernate.show_sql", "true");
	    props.put("hibernate.hbm2ddl.auto", "update");
	    return props;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager tm = new HibernateTransactionManager();
	    tm.setSessionFactory(sessionFactory);
	    return tm;
	}

}
