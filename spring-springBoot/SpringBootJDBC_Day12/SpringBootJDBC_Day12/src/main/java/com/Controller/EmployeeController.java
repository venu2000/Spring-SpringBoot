package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
@RestController
public class EmployeeController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;        //no manual config needed, SB will take care everything
	
	@GetMapping("/saved")
	public String save() {
		
		/*
		 * //this Product object is not used in the code, it is writen for just to
		 * //understand how Lombok works 
		 * 
		 * Product p =new Product(); p.getId();
		 * p.setName("Venu");
		 */
        
		jdbcTemplate.update("INSERT into products values(?,?,?)", 4, "SSD", 90000);
		return "Saved";
		
		
		
		
		
		
		
	}

}
