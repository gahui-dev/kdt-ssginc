package com.java.class07;

import com.java.class06.Lamp;

public class ApproachTest01 {
	// 접근제한자 public > (default) > private
	// public 모든 객체에서 접근 가능
	// (default) 같은 패키지 안에서만 접근 가능
	// protected 상속
	
	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		lamp.turnOn();
		lamp.on = true;
		
		System.out.println(args);
	}
}
