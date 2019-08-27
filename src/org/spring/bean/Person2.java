package org.spring.bean;

import java.util.List;

public class Person2 {

	private String name;
	private int age;
	private List<Car> car;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
}
