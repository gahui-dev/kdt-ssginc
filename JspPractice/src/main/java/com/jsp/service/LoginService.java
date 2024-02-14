package com.jsp.service;

import com.jsp.dao.LoginDAO;
import com.jsp.dto.PersonDTO;

public class LoginService {
	private static final LoginService _instance = new LoginService();
	public static LoginService getInstance() {
		return _instance;
	}
	
	private LoginDAO dao = LoginDAO.getInstance();
	
	public PersonDTO loginPersonInfo(PersonDTO personDto) {
		PersonDTO personInfo = dao.selectPersonInfo(personDto);
		
		if(personInfo != null) {
			System.out.println("login success");
			return personInfo;
		} else {
			System.out.println("로그인 실패 ");
			return null;
		}
	} 
}
