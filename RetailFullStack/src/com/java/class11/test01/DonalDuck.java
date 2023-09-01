package com.java.class11.test01;

import com.java.class11.test01.behavior.impl.FlyWithRocketEngine;
import com.java.class11.test01.behavior.impl.QuackLikeMan;

public class DonalDuck extends Duck{
	public DonalDuck() {
		super("도날드 덕");
		setQuackBehavior(new QuackLikeMan());
		setFlyBehavior(new FlyWithRocketEngine());
	}

	@Override
	public void swim() {
		System.out.println("저는 수영을 못해요");		
	}
	
}
