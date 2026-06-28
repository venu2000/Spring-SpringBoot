package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	
	@Value("${stid}")
	private int UserId;
	@Value("${name}")
	private String name;
	
     @Autowired  // field level Autowring   & we can also keep at setter level also 
     Address address; 
	
	public User() {
		
	}
	
	public User(int userId, String name) {
		super();
		UserId = userId;
		this.name = name;
	}
	public User(int userId, String name, Address address) {
		super();
		UserId = userId;
		this.name = name;
		this.address = address;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	
	@Override
	public String toString() {
		return "User2 [UserId=" + UserId + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
	
	

}
