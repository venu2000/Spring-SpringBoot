package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
//	@RequestMapping("/user")
//	@ResponseBody
//	public String user() {
//		return "Hi ! There";
//		
//	}
	
	
	@RequestMapping("/user")
	
	public String user(Model model) {
		model.addAttribute("name", "Venu");
		return "user";
		
	}
}
