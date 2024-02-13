package com.java.class09.test02;

import com.java.class09.Animal;

public class Eagle extends Animal {
	String 날개 = "날개";
	
	public Eagle(String name) {
		//1. super.name
		//super.name = name;
		// 2. super(name)
		super(name);
	}
	
	private void 날다() {
		System.out.println(this.name + "가 "+ this.날개 + "로 날다");
	}
	
	public void 이동하다() {
		날다();
	}
}
