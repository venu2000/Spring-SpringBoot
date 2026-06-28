package com.model;

public class User {
	
	
	
	private int UserId;
	private String name;
	
     Address address; 
	
	
	
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
