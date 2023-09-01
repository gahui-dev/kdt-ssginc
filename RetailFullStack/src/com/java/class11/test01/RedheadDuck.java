package com.java.class11.test01;

import com.java.class11.test01.behavior.impl.FlyWithWings;
import com.java.class11.test01.behavior.impl.Quack;

public class RedheadDuck extends Duck{
	public RedheadDuck() {
		super("빨간머리 오리");		
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}
	
	@Override
	public void swim() {
		System.out.println("헤엄칩니다~ 둥둥");
	}

}
