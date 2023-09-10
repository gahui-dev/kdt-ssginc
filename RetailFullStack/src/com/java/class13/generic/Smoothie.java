package com.java.class13.generic;

public class Smoothie implements Beverage{
	private String name;
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
