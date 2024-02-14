package com.service;

import java.util.List;

import com.dto.Cat;

public class UserService {
	// 1 : n
	List<Cat> list;

	public List<Cat> getList() {
		return list;
	}

	// setter-based DI
	public void setList(List<Cat> list) {
		this.list = list;
	}
	
	// 추가 메서드 
	public String getMesg() {
		return "hello world";
	}
	
}
