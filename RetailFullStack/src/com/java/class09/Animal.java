package com.java.class09;

public class Animal {
	protected String 눈 = "눈";
	String 주둥이 = "주둥이";
	protected String name;
	
	public Animal() {
		super();
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void 먹다() {
		System.out.println(this.name + "가 "+ this.주둥이 +"로 먹다");
	}
	
	public void 잠자다() {
		System.out.println(this.name + "가 "+ this.눈 + "을 감고 잠자다");
	}
	
	public void 이동하다() {
		System.out.println("여기");
	}
}
