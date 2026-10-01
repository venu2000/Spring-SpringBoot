package com.flm.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flm.dao.PersonRepository;
import com.flm.dto.PersonDetailsDto;
import com.flm.dto.SignUpRequestDto;
import com.flm.model.Person;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class PersonService {

	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	
	public PersonDetailsDto signUp(SignUpRequestDto signUpRequestDto) {
		
		System.out.println("SIGNUP API HIT");
		
		Person person = new Person();
		
		
		person.setUserName(signUpRequestDto.getUserName());
		String password = signUpRequestDto.getPassword();
		
		String encodedPassword = passwordEncoder.encode(password);
		person.setPassword(encodedPassword);
		
		System.out.println("Before Save");
		
		
		Person saved = personRepository.save(person);
		
		System.out.println("Saved User Id = " + saved.getPersonId());
		
		PersonDetailsDto personDetailsDto = new PersonDetailsDto();
		BeanUtils.copyProperties(saved, personDetailsDto);
		
		return personDetailsDto;
	
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
