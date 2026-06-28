package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.model.Jio;
import com.model.Sim;

@Component
//@Scope("prototype")
public class SimTest {
	
	@Autowired
//	@Qualifier(value = "jio")
	
	//Qualifier is used to mention needed bean name explicitly 
	// airtel is default beanName if clss name is AirtelSim bean name will be airtelSim
	Sim sim;
	
//	@Autowired
//	@Qualifier(value = "jio")
//	Sim sim2;
	
	
//	
	public void simCall() {
		
		sim.call();
//		sim2.call();
		
	}
	
	
	
	
	
	

}
