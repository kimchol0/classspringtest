package org.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.spring.bean.Car;
import org.spring.bean.Person;
import org.spring.bean.Person2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		System.out.println(car2.toString());
		DataSource ds = (DataSource)ctx.getBean("dataSource");
		System.out.println(ds.getConnection());

	}
	
}
