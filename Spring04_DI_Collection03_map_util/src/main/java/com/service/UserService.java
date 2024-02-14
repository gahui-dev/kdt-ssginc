package com.service;

import java.util.Map;

import com.dto.Cat;

public class UserService {
	// 1 : n
	Map<String, Cat> map;
	
	public Map<String, Cat> getMap() {
		return map;
	}

	// DI
	public void setMap(Map<String, Cat> map) {
		this.map = map;
	}

	public String getMesg() {
		return "Hello world";
	}
	
}
