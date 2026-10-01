package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.PersonDetailsDto;
import com.flm.dto.SignUpRequestDto;
import com.flm.service.PersonService;

@RestController
@RequestMapping("/user")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	
	@PostMapping("/signUp")
	public PersonDetailsDto signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
		return personService.signUp(signUpRequestDto);
	}
	
	
	
	@GetMapping("/hi")
	public String hi() {
		return "You are logged in ....";
	}
	
	
	

}
