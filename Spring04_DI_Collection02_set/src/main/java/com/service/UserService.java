package com.service;

import java.util.Set;

import com.dto.Cat;

public class UserService {
	// 1 : n
	Set<Cat> set;

	public Set<Cat> getSet() {
		return set;
	}

	public void setSet(Set<Cat> set) {
		this.set = set;
	}
	
	public String getMesg() {
		return "Hello world";
	}
	
}
