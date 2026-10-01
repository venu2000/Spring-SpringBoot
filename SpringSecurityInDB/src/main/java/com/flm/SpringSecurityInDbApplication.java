package com.flm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringSecurityInDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityInDbApplication.class, args);
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		
		
		
		httpSecurity.csrf(csrf->csrf.disable())
		
		
		
		.authorizeHttpRequests(
				
		             auth -> auth.requestMatchers("/user/signUp").permitAll()
		             .anyRequest()
		             .authenticated()
		          
				)
		.formLogin(org.springframework.security.config.Customizer.withDefaults())
		.httpBasic(org.springframework.security.config.Customizer.withDefaults());
		
		
		return httpSecurity.build();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
