package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	
	
	@RequestMapping("/hi")
	//@ResponseBody     // we elemenated response body 
	//so @controller by default dsplay views
	public String hi() {
		return "hi";
		
	}
	
	
	@RequestMapping("/bye")
	@ResponseBody            // it displays Data
	public String bye() {
		return "bye...";
	}

}
