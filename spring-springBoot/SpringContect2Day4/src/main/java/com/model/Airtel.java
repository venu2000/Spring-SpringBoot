package com.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary  

// it will give precedence at Dynamic level dispatch to avoid ambiguity 
public class Airtel implements Sim{

	@Override
	public void call() {
		
		System.out.println("Airtel calling....");
		
	}

}
