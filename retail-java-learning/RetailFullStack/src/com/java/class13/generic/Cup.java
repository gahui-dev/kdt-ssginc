package com.java.class13.generic;

public class Cup<T extends Beverage>{
	private T beverage;
	
	public T getBeverage() {
		return this.beverage;
	}
	
	public void setBeverage(T beverage) {
		this.beverage = beverage;
	}
}
