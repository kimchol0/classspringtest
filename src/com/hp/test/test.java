package com.hp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String args[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop.xml");
		
		ArithmeticCalculator calculator = (ArithmeticCalculator)ctx.getBean("calculator");
		
		System.out.println(calculator.getClass().getName());
		
		int result = calculator.add(5, 8);
		System.out.println("result:"+result);
		
	}
	
}
