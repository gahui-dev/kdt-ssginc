package com.java.class11.test01;

import com.java.class11.test01.behavior.FakeQuack;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		Duck duck = new RedheadDuck();
		doPerform(duck);
		
		System.out.println("주소 > " + duck);
		
		doPerform(new MallardDuck());
		doPerform(new RubberDuck());
		
		duck = new DecoyDuck();
		duck.setQuackBehavior(new FakeQuack());
		doPerform(duck);
		
		doPerform(new DonalDuck());
		
		while(true) {
			System.out.println("안녕");
			System.out.println((int)(Math.random() * 2));
			Thread.sleep(1000); // 1s, 잠잔다
		}
	}
	
	
	public static Duck doPerform(Duck duck) {
		duck.display();
		duck.performQuack();
		duck.swim();
		duck.performFly();
		
		return duck;
	}
}
