package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dao.PersonRepository;
import com.flm.model.Person;
import com.flm.security.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;
	
	@PostMapping("/signup")
	public Person signUp(@RequestBody Person person) {
		
		String encodedPasssword = passwordEncoder.encode(person.getPassword());
		person.setPassword(encodedPasssword);
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Person person) {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(person.getUserName(), person.getPassword()));
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials !!");
//		}
//		
//	//	String token = jwtService.generateToken(person.getUserName());
//		String token = jwtService.generateToken(person);
//		return ResponseEntity.ok(token);

		try { 
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( person.getUserName(), person.getPassword() ) ); 
			
			 Person username = personRepository .findPersonByUserName(person.getUserName()); 
			 
			 String token = jwtService.generateToken(username); 
			 
return ResponseEntity.ok(token); } 
		
		catch (Exception ex) { 
			ex.printStackTrace();
			return ResponseEntity .status(HttpStatus.UNAUTHORIZED) .body("Invalid Credentials !!"); }
		}
	}


