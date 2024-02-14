package com.jsp.service;

import com.jsp.dao.MyPageDAO;
import com.jsp.dto.PersonDTO;

public class MyPageService {
	private static final MyPageService _instance = new MyPageService();
	public static MyPageService getInstance() {
		return _instance;
	}
	
	private MyPageDAO dao = MyPageDAO.getInstance();
	
	public PersonDTO showPerson(String userid) {
		PersonDTO personInfo = dao.selectPersonInfo(userid);
		
		if(personInfo != null) {
			System.out.println("정보 불러오기 ");
			return personInfo;
		} else {
			System.out.println("정보 불러오기 실패 ");
			return null;
		}
		
	}
	
	public boolean editPerson(PersonDTO personDto) {
		if(dao.updatePersonInfo(personDto) == 1) {
			System.out.println("업데이트 성공 ");
			return true;
		} else {
			System.out.println("업데이트 실패 ");
			return false;
		}
	}
}
