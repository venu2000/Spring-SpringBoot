package com;

import java.io.ObjectInputFilter.Config;
import com.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class Application {
	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(com.Config.Config.class);
		SimTest simTest = ctx.getBean("simTest",SimTest.class);
		SimTest simTest2 = ctx.getBean("simTest",SimTest.class);
		
		
		/*
		 * // to test @Scope("prototype") System.out.println(simTest);
		 * System.out.println(simTest2);
		 */
		
		simTest.simCall();
		
		
		
		
		
	}

	
	
	

}
