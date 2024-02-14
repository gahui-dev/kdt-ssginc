package com.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	public UserDAO() {
		System.out.println("UserDAO 생성자");
	}
	
	public String getMesg() {
		return "userDAO.hello";
	}
}
