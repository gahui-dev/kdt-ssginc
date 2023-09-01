package com.java.class11.test01.behavior.impl;

import com.java.class11.test01.behavior.QuackBehavior;

public class Mute implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("...");
		
	}

}
