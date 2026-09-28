package com.flm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flm.dao.PersonRepository;
import com.flm.model.Authority;
import com.flm.model.Person;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepository.findPersonByUserName(username);
		List<Authority> authorities = person.getAuthorities();
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		for(Authority authority : authorities) {
			
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+ authority.getRole()));
			
		}
		return User.builder()
			.username(person.getUserName())
			.password(person.getPassword())
			.authorities(grantedAuthorities)
			.build();
	}

}
