package org.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
		public static void main(String[]args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserController userController = (UserController)ctx.getBean("userController");
			userController.execute();
	}
}
