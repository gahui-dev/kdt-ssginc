package com.service;

import org.springframework.stereotype.Component;

// @Component
@Component("xxx")
public class UserService {
	public UserService() {
		System.out.println("UserService 생성자 ");
	}
	
	public String getMesg() {
		return "hello";
	}
}
