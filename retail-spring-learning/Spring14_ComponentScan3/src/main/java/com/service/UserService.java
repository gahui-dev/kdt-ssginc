package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;

@Service("xxx")
public class UserService {
	
	@Autowired
	UserDAO dao;
	
	public String getMesg() {
		return dao.getMesg();
	}
}
