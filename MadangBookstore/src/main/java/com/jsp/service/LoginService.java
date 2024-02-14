package com.jsp.service;

import java.util.ArrayList;

import com.jsp.dao.CustomerDAO;
import com.jsp.dto.CustomerDTO;

public class LoginService {
	private static final LoginService _instance = new LoginService();
	public static LoginService getInstance() {
		return _instance;
	}
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public CustomerDTO loginCustomer(CustomerDTO customerDto) {
		ArrayList<CustomerDTO> CustomerInfo = dao.selectCustomer(customerDto);
		System.out.println(CustomerInfo.size());
		
		if(CustomerInfo.size() == 1) {			
			
			System.out.println("로그인 성공");
			return CustomerInfo.get(0);
		} else {
			System.out.println("로그인 실패");
			return null;
		}
	}
}
