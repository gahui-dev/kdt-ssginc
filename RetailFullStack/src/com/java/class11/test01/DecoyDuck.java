package com.java.class11.test01;

import com.java.class11.test01.behavior.impl.FlyNoWay;
import com.java.class11.test01.behavior.impl.Mute;

public class DecoyDuck extends Duck{
	public DecoyDuck() {
		super("나무오리");
		setQuackBehavior(new Mute());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public void swim() {
		System.out.println("헤엄칠 수 없다");
	}
}
