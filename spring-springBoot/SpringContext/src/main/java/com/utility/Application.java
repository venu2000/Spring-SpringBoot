package com.utility;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Address;
import com.model.User;
import com.model.User2;

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
		 User user2 = container.getBean("user2" , User.class);

		System.out.println(user1);
		System.out.println(user2);

		User user3 = container.getBean("user3" , User.class);
		
System.out.println(user3);


User user4 = container.getBean("user4" , User.class);
System.out.println(user4.hashCode());
User user5 = container.getBean("user4" , User.class);
System.out.println(user5.hashCode());



//---------------------------------------------------------------
Address address = container.getBean("address", Address.class);
System.out.println(address);
User2 user21 = container.getBean("user21", User2.class);
System.out.println(user21);




	}

}
