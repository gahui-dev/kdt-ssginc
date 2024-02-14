package com.jsp.service;

import com.jsp.dao.UserDAO;
import com.jsp.dto.UserDTO;

public class UserService {
	private static final UserService _instance = new UserService();
	public static UserService getInstance() {
		return _instance;
	}
	
	private UserDAO dao = UserDAO.getInstance();
	
	public boolean signUpService(UserDTO userDto) {		
		if(dao.signUp(userDto) == 1) {
			System.out.println("회원가입 성공");
			return true;
		} else {
			System.out.println("회원가입 실패");
			return false;
		}		
	}
	
	public UserDTO signInService(UserDTO userDto) {
		UserDTO userInfo = dao.signIn(userDto);
		
		if(userInfo != null) {
			System.out.println("로그인 성공 ");
			return userInfo;
		} else {
			System.out.println("로그인 실패 ");
			return null;
		}		
	}
}
