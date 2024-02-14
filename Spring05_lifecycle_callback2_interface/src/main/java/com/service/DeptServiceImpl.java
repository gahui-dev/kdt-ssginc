package com.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DeptServiceImpl implements InitializingBean, DisposableBean {
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl 생성자");
	}
	
	// 기능 처리
	public String getMesg() {
		return "Hello World";
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("xxx 초기화");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("yyy 자원 반납 ");
	}
}
