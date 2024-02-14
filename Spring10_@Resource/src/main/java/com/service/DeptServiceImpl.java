package com.service;


import javax.annotation.Resource;


import com.dao.DeptDAO;

public class DeptServiceImpl {
	
	@Resource
	DeptDAO yyy;
	
	public String getMesg() {
		return yyy.getMesg(); 		
	}
}
