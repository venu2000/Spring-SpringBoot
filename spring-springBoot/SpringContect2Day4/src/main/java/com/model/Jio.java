package com.model;

import com.Config.Config;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Jio implements Sim{
	
	
	
	public Jio() {
		System.out.println("jio object created ...");
		
	}

	@Override
	public void call() {
		
		System.out.println("Jio calling ...");
		
	}
	
// when ever we run application , @PostConstrcuture will will executed even the method didtn call in main 	
	@PostConstruct
	public void initTest() {
		System.out.println("init calling ...");
		
	}

}
