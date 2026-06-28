package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

@Configuration

public class Config {
	
	// if class is not user defined class, we create a method in config class
	// and then we use @Bean on predefined class
	@Bean("template")
	public JdbcTemplate jdbcTemplate() {
		DataSource dataSource = dataSource();
		return new JdbcTemplate(dataSource);
		
	}
	
	@Bean
	public DataSource dataSource() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate");
		dataSource.setUsername("root");
		dataSource.setPassword("Venu@1526");
		return dataSource;
		
		
	}

}
