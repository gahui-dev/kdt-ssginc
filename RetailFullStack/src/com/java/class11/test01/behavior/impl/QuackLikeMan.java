package com.java.class11.test01.behavior.impl;

import com.java.class11.test01.behavior.QuackBehavior;

public class QuackLikeMan implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("사람처럼 대화해요~");		
	}

}
