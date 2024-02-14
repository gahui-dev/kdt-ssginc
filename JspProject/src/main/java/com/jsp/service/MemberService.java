package com.jsp.service;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberDTO;

import java.util.List;
import java.util.Map;

public class MemberService {
	private static final MemberService _instance = new MemberService();
	private MemberDAO dao = MemberDAO.getInstance();
	
	// 회원가입 
	public boolean joinUser(MemberDTO joinDto) {
		boolean success = false;
		
		System.out.println(dao.insertUser(joinDto));
	
		if(dao.insertUser(joinDto) == 1) {
			success = true;
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		return success;
	}

	public List<Map<String, Object>> showUser(){
		return dao.selectUser();
	}
	
	// 회원정보 
}
