package com.flm.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/hi")
	@PreAuthorize("hasRole('ADMIN')")
	public String hi(){
		return "Hii you have valid ADMIN JWT";
	}
	
	@GetMapping("/bye")
	@PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
	public String bye(){
		return "Bye you have valid SUPER ADMIN / ADMIN JWT";
	}
	
	@GetMapping("/revenue")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public int revenue() {
		return 100000;
	}
	
	@GetMapping("/open")
	public String open() {
		return "You have a valid JWT";
	}
}
