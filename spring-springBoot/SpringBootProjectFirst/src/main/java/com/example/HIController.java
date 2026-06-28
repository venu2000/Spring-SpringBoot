package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HIController {
	
	@GetMapping("/hi")
	public String hi() {
		return "hi! this is my First Spring Boot Project";
		
	}
	
	

}
