package com.java.class06;

public class Lamp {
	// 멤버 변수 / 속성 / 필드 / 프로퍼티
	boolean on = false;
	boolean off = true;
	
	// 멤버 메서드
	public void turnOn() {
		on = true;
		off = false;
	}
	
	public void turnOff() {
		off = true;
		on = false;
	}
	
	public void printStatusOfLamp() {
		if(on == true && off == false) {
			System.out.println("Lamp가 켜져 있네요");
		} else if(off == true && on == false) {
			System.out.println("Lamp가 꺼져 있네요");			
		}
	}
}
