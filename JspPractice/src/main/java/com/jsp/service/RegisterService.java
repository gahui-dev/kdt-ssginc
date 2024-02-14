package com.jsp.service;

import com.jsp.dao.RegisterDAO;
import com.jsp.dto.PersonDTO;

public class RegisterService {
	private static final RegisterService _instance = new RegisterService();
	public static RegisterService getInstance() {
		return _instance;
	}
	
	private RegisterDAO dao = RegisterDAO.getInstance();
	
	public boolean resgisterPerson(PersonDTO personDto) {
		if(dao.insertPerson(personDto) == 1 ) {
			System.out.println("등록 성공 ");
			return true; 
		} else {
			System.out.println("등록 실패 ");
			return false;
		}
	}
}
