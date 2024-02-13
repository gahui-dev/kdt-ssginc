package com.java.class06;

public class Lamp {
	// 멤버 변수 / 속성 / 필드 / 프로퍼티
	public boolean on = false;
	private boolean off = true;
	private String name = "";
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name + "님";
	}
			
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
