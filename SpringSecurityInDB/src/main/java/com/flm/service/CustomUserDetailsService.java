package com.flm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flm.dao.PersonRepository;
import com.flm.model.Person;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Person person = personRepository.findPersonByUserName(username);
		
		UserDetails userDetails = User.builder()
				
				.username(person.getUserName())
				.password(person.getPassword())
				.build();
		
		return userDetails;
	}

}
