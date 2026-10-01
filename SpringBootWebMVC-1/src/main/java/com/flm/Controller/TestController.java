package com.flm.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flm.model.User;

@Controller
public class TestController {
	
	
	@GetMapping("/hi")
	public String hi() {
		
		return "hi";
		
	}
	
	
	@GetMapping("/data")
	public String data(Model model) {
		model.addAttribute("name", "Venu Gopal");
		return "data";
		
	}
	
	
	
	/*
	 *  This is code for How we print through @ResponseBody (data)
	 *  */
	
//	@PostMapping("/login")
//    @ResponseBody
//	public String login(@RequestParam String email, @RequestParam String password) {
//		
//		return "Hi  "  + email +"  Your Password is : " +password ;
//		
//	}
	
	
	/* 
	 * This is code to return respons through Views 
	 * */
	
	@PostMapping("/login")
 
	public String login(@RequestParam String email, @RequestParam String password,Model model) {
		model.addAttribute("email",email);
		model.addAttribute("password",password);
		return "info" ;
		
	}
	
	
	/* 
	 * Thymeleaf with Objects 
	 * 
	 * */
	
	@GetMapping("/hiModel")
	public String hiModel(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "hi";
		
	}
	
	@PostMapping("loginModel")
	public String loginModel(@ModelAttribute User user, Model model) {
		
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());		
		return "info";
		
	}
	
	
	
	/* 
	 * Thymeleaf with Tables 
	 * 
	 * */
	
	@GetMapping("/listUser")
	public String listUsers(Model model) {
		
		List<User> users = new ArrayList<>();
		users.add(new User("Venu", "152620"));
		users.add(new User("Navi", "2615"));
		users.add(new User("Susu", "2002"));
		
		model.addAttribute("userList",users);
		return "users";
		
		
		
		
		
		
		
	}
	
	
	

}
