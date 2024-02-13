package com.java.class11.test01.behavior.impl;

import com.java.class11.test01.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior{
	public void fly() {
		System.out.println("날지 못하다");
	}
}
