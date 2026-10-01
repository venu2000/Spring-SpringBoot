package com.flm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
		
		
		httpSecurity.csrf(csrf->csrf.disable())
		.cors(cors->cors.disable())
		.authorizeHttpRequests(
				auth-> auth.anyRequest().authenticated());
				
				return httpSecurity.build();
		
	}
	
	
	
	
	
	

}
