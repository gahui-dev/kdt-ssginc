 package com.example.service;

import org.springframework.stereotype.Service;

@Service("xxx")
public class DeptServiceImpl {
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl");
	}
	
	public String sayHello() {
		return "Hello ~~~~~~~ ";
	}
}
