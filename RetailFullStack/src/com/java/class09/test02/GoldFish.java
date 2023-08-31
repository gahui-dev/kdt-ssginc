package com.java.class09.test02;

import com.java.class09.Animal;

public class GoldFish extends Animal{
	String 지느러미 = "지느러미";
	
	public GoldFish(String name) {
		super.name = name;
	}
	
	private void 헤엄치다() {
		System.out.println(this.name + "가 "+ this.지느러미 + "로 헤엄치다");
	}
	
	public void 이동하다() {
		헤엄치다();
	}
}
