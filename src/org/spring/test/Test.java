package org.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		HelloWorld hw = new HelloWorld();
		hw.setName("123");
		hw.hello();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld h = (HelloWorld) ctx.getBean("helloWorld");
		h.hello();
		
		System.out.println("hw:"+hw);
		System.out.println("h:"+h);
		
	}
	
	
}
