package com.service;

public class DeptServiceImpl {
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl 생성자");
	}
	
	// 기능 처리
	public String getMesg() {
		return "Hello World";
	}
	
	// 반드시 public void, 파라미터 없어야
	// init-method="xxx"
	public void xxx() {
		System.out.println("xxx 초기화 ");
	}
	
	// destroy-method="yyy"
	public void yyy() {
		System.out.println("yyy 자원반납 ");
	}
}
