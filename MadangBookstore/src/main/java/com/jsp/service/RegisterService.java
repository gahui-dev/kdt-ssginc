package com.jsp.service;

import com.jsp.dao.CustomerDAO;
import com.jsp.dto.CustomerDTO;

public class RegisterService {
	private static final RegisterService _instance = new RegisterService();
	public static RegisterService getInstance() {
		return _instance;
	}
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public boolean registerCustomer(CustomerDTO customerDto) {
		
		if(dao.insertCustomer(customerDto) == 1) {
			System.out.println("회원가입 성공");
			return true;
			
		} else {
			System.out.println("회원가입 실패");
			return false;
		}
	}
}
