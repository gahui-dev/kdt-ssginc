package com.service;

public class DeptServiceImpl {
	public DeptServiceImpl(int n) {
		System.out.println("DeptServiceImpl 생성자" + n);
	}
	
	
	public DeptServiceImpl(int n, String name) {
		System.out.println("DeptServiceImpl 생성자" + n + name);
	}
	
	// 기능 처리
	public String getMesg() {
		return "Hello World";
	}
}
