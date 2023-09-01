package com.java.class11.test01;

import com.java.class11.test01.behavior.FlyBehavior;
import com.java.class11.test01.behavior.QuackBehavior;

public abstract class Duck {
	private String name;
	private QuackBehavior quackBehavior;
	private FlyBehavior flyBehavior;
	
	public Duck(String name) {
		this.name = name;
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	
	public String getName() {
		return this.name;
	}	
	
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(getName());
	}
	
	public abstract void swim();
}
