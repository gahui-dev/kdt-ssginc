package com.java.class11.test01;

import com.java.class11.test01.behavior.impl.FlyNoWay;
import com.java.class11.test01.behavior.impl.Squeak;

public class RubberDuck extends Duck {

	public RubberDuck() {
		super("고무오리");
		setQuackBehavior(new Squeak());
		setFlyBehavior(new FlyNoWay());
	}
	
	@Override
	public void swim() {
		System.out.println("물에 둥둥 떠있습니다");
	}

}
