//유지보수를 위해 로그인, 회원가입 서비스 분리 
//package com.jsp.service;
//
//import com.jsp.dao.CustomerDAO;
//import com.jsp.dto.CustomerDTO;
//
//public class CustomerService {
//	private static final CustomerService _instance = new CustomerService();
//	public static CustomerService getInstance() {
//		return _instance;
//	}
//	private CustomerDAO dao = CustomerDAO.getInstance();
//	
//	// 로그인
//	public boolean loginCustomer(CustomerDTO customerDto) {
//		if(dao.selectCustomer(customerDto)) {
//			System.out.println("로그인 성공");
//			return true;
//		} else {
//			System.out.println("로그인 실패");
//			return false;
//		}
//	}
//	
//	// 회원가입
//	public boolean registerCustomer(CustomerDTO customerDto) {
//		
//		if(dao.insertCustomer(customerDto) == 1) {
//			System.out.println("회원가입 성공");
//			return true;
//			
//		} else {
//			System.out.println("회원가입 실패");
//			return false;
//		}
//	}
//}
