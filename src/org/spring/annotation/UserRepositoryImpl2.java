package org.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepository2")
public class UserRepositoryImpl2 implements UserRepository {
	
	@Autowired(required=false)
	private TestObject testObject;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepositoryImpl... save..222");
		System.out.println(testObject);
	}

}
