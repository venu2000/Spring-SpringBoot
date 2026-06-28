package com.model;

import java.util.List;
import java.util.Map;

public class User {
	
	//content -1 , create G&S for these so that we can use <property> tag and send values to these fields 

	int userId;
	String name;
	
	
	
	//content -3 , lets create list and learn how to insert values in it 
	List<String> skills;
	// lets create G&S for it no need constructor because we are using<property> tag
	
	
	Map<String, String> hobbies;
	
	
	
	
	
public Map<String, String> getHobbies() {
		return hobbies;
	}



	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}



public List<String> getSkills() {
		return skills;
	}



	public void setSkills(List<String> skills) {
		this.skills = skills;
	}


//content 2 - create Parameterized Constructor , to send values through 
	//<constructor-args>
public User(int userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}



public User() {
	
}



public int getUserId() {
	return userId;
}



public void setUserId(int userId) {
	this.userId = userId;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



@Override
public String toString() {
	return "User [userId=" + userId + ", name=" + name + ", skills=" + skills + ", hobbies=" + hobbies + "]";
}







	
	
	

}
