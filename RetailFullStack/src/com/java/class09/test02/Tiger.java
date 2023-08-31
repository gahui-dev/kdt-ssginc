package com.java.class09.test02;

import com.java.class09.Animal;

public class Tiger extends Animal{
	String 다리 = "다리";
	
	public Tiger(String name) {
		super.name = name;
	}
	
	public void 달리다() {
		System.out.println(this.name + "가 "+ this.다리 + "로 달리다");
	}
	
	public void 이동하다() {
		달리다();
	}
 }
