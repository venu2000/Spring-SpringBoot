package com.flm.Controller;

import org.apache.naming.factory.MailSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JMSController {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	@GetMapping("/email")
	public String sendMail(@RequestParam(name = "toEmail")String toEmail) {
		
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("venugopalalapati2k@gmail.com");
		mail.setTo(toEmail);
		mail.setSubject("Order Places Successfully....");
		mail.setText("Your order will be Delivered in 2 days ");
		
		javaMailSender.send(mail);
		
		
		
		return "Mail Sent Successfully.........";
		
	}
	
	

}
