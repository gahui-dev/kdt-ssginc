 package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dao.DeptDAO;

@Service("xxx")
public class DeptServiceImpl {
	
	DeptDAO dao;
	
	public DeptServiceImpl(DeptDAO dao) {
		System.out.println("DeptServiceImpl");
		this.dao = dao;;
	}
	
	public String getMesg() {
		return dao.getMesg();
	}
}
