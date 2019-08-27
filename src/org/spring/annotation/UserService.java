package org.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userRepository2")
	private UserRepository userRepository;
	
	public void add() {
		System.out.println("UserService add...");
		userRepository.save();
	}

}
