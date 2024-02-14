package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DeptDAO;

public class DeptServiceImpl {
	
	@Autowired(required = false)
	DeptDAO dao;
	
	public String getMesg() {
		return dao.getMesg(); 		
	}
}
