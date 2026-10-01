package com.flm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi......";
	}

}
