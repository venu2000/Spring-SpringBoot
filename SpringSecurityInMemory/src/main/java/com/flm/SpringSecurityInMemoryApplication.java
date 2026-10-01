package com.flm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class SpringSecurityInMemoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityInMemoryApplication.class, args);
	}
	
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		
		
		UserDetails user1 = User.builder().username("Venu")
		.password(passwordEncoder.encode("Secret"))
		.build();
		
		

		UserDetails user2 = User.builder().username("Naveena")
		.password(passwordEncoder.encode("Secret1"))
		.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
		
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		
		
		httpSecurity.authorizeHttpRequests(
				
				auth-> auth.requestMatchers("/hi","/bye").authenticated()
				           .requestMatchers("/open").permitAll()
				           .requestMatchers("/noAccess").denyAll()
				           )
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
	}
	
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	
	
	
	
	

}
