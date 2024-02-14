package com.service;

// target 클래스
public class UserService {
	// 핵심 기능 메서드
	public String sayHello() {
		System.out.println("UserSErvice.sayHello");
		return "Hello :)";
	}
	
	public String callHello() {
		System.out.println("UserService.callHello");
		return "world";
	}
	
	public String echoHello() {
		System.out.println("UserService.echoHello");
		
		// 예외처리 
		int num = 10/0;
		
		return "happy";
	}
}

