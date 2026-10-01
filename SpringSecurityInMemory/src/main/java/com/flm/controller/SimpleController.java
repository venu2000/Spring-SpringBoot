package com.flm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi......";
	}
	
	@GetMapping("/bye")
	public void bye() {
		System.out.println("bye......");
	}
	
	@GetMapping("/open")
	public void open() {
		System.out.println("Open......");
	}
	
	@GetMapping("/noAccess")
	public void noAccess() {
		System.out.println("NoAccess......");
	}

}
