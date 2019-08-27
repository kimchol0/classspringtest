package org.spring.test;

import org.spring.bean.Car;
import org.spring.bean.DataSource;
import org.spring.bean.Person;
import org.spring.bean.Person2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2.toString());
		
		Person p = (Person) ctx.getBean("person");
		System.out.println(p.toString());;
		
		Person2 p2 = (Person2)ctx.getBean("person5");
		System.out.println(p2.toString());;
		
		DataSource datasource = (DataSource) ctx.getBean("dataSource");
		System.out.println(datasource);
	}
	
}
