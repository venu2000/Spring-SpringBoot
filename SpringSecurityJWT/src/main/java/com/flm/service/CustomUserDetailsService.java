package com.flm.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flm.dao.PersonRepository;
import com.flm.model.Authority;
import com.flm.model.Person;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	Authority authority;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Person person = personRepository.findPersonByUsername(username);
		
		
		List<Authority> authorities = person.getAuthorities();
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		for(Authority authority : authorities) {
			
			
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole()));
			
			
			
			
		
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		UserDetails userDetails = User.builder()
		.username(person.getUserName())
		.password(person.getPassword())
		.authorities(grantedAuthorities)
		.build();
	
		
		return userDetails;
	}

}
