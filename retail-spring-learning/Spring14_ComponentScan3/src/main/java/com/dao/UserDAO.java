package com.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	public UserDAO() {
		System.out.println("UserDAO 생성자");
	}
	
	public String getMesg() {
		return "userDAO.hello";
	}
}
