package com.jsp.service;

import com.jsp.dao.LoginDAO;
import com.jsp.dto.CustomerEntity;
import com.jsp.dto.LoginDTO;

public class LoginService {

	private LoginDAO dao = LoginDAO.getInstance();
	private static LoginService _instance = new LoginService();

	public static LoginService getInstance() {
		return _instance;
	}

	public boolean findUserAndPwd(LoginDTO loginDto) {
		boolean success = false;
		if (dao.selectUserAndPwd(loginDto) == 1) {
			success = true;
		}
		return success;
	}

	public String findWordByKey(String queryKey) {
		return queryKey;
	}

	public CustomerEntity readUserByUserNameAndPwd(LoginDTO dto) {
		return dao.selectUserByUserNameAndPwd(dto);
	}

}
