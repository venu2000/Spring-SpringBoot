package com.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages  ="com")
@Configuration
@PropertySource("classpath:application.properties")

public class Config {

}
