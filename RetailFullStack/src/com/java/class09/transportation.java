package com.java.class09;

public class transportation {
	protected String type;
	protected int wheels;
	protected int numberOfPassengers;
	
	public transportation() {}
	
	public transportation(String type, int wheels, int numberOfPassengers) {
		this.type = type;
		this.wheels = wheels;
		this.numberOfPassengers = numberOfPassengers;
		
	}
	
	public void print() {
		System.out.println(type + " 탑승 인원: " + numberOfPassengers + "명, 바퀴 수:" + wheels);
	}
	
	public void start() {
		System.out.println(type + "가 달리다");
	}
	
	public void brake() {
		System.out.println(type + "가 브레이크를 밟다");
	}
	
	public void stop() {
		System.out.println(type + "가 정지하다");
	}

}
