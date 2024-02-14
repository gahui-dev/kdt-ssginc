package com.service;

import com.dao.DeptDAO;

public class DeptServiceImpl {
	DeptDAO dao;
	
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl 생성자");
	}
		
	// setter 메서드 이용한 주입
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	public String getMesg() {
		return dao.getMesg(); 		
	}

	public DeptDAO getDao() {
		return dao;
	}
	
}
