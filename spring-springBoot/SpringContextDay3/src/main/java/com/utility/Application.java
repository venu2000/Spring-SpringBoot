package com.utility;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Address;
import com.model.User;
import com.model.User;

public class Application {

	public static void main(String[] args) {
	
	     //ApplicationContext[I]it is a container where all beans are stored
		//ClassPathXmlApplicationConext is a class which implements ApplicationContext, 
		// it is a Dynamic dispatch used here
		//we must mention bean.xml,becuase container stors beans there
		
		
		
		 ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		 
		 //.getBean fetch the mentioned bean
		//user -> is a id where we mentioned at bean.xml, by this reference it will fetch the bean 
		 //we also must mention the class name for the reference
		 
		
		 
		 
		 User user1 = container.getBean("user", User.class);
		
		System.out.println(user1);
	



	}

	

}
