package com.java.class11.test01.behavior.impl;

import com.java.class11.test01.behavior.FlyBehavior;

public class FlyWithRocketEngine implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("로켓 엔진으로 날아오르다~"); 
	}

}
