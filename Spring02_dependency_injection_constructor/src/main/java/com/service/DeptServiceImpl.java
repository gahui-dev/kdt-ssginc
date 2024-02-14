package com.service;

import com.dao.DeptDAO;

public class DeptServiceImpl {
	DeptDAO dao;
	String name;
	
	public DeptServiceImpl(DeptDAO x) {
		System.out.println("DeptServiceImpl 생성자");
		dao = x;
	}
	
	public DeptServiceImpl(String name, DeptDAO x) {
		System.out.println("DeptServiceImpl 생성자");
		dao = x;
		this.name = name;
	}
	
	// 고전 방식: 기능 처리
	public String getMesg() {
		return dao.getMesg() + "\t" + name; 		
	}
}
