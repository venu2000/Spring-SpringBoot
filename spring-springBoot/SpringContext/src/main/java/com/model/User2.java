package com.model;

public class User2 {
	
	
	
	private int UserId;
	private String name;
	Address address;       //->byType 
	
	Address address2;      //->byName
	
	
	
	public Address getAddress2() {
		return address2;
	}
	public void setAddress2(Address address2) {
		this.address2 = address2;
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
		return "User2 [UserId=" + UserId + ", name=" + name + ", address=" + address + ", address2=" + address2 + "]";
	}

	
	
	
	
	
	
	

}
