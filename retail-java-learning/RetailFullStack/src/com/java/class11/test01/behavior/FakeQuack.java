package com.java.class11.test01.behavior;

public class FakeQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("꽤~~액 가짜 울음");		
	}

}
