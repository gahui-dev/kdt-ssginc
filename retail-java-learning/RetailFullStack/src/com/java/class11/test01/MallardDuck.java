package com.java.class11.test01;

import com.java.class11.test01.behavior.impl.FlyWithWings;
import com.java.class11.test01.behavior.impl.Quack;

public class MallardDuck extends Duck {
	public MallardDuck() {
		super("청둥오리");
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}
	
	@Override
	public void swim() {
		System.out.println("헤엄칩니다~ 둥둥");
	}


}
