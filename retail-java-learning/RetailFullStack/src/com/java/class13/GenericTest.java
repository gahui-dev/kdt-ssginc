package com.java.class13;

import com.java.class13.generic.Beverage;
import com.java.class13.generic.Coffee;
import com.java.class13.generic.Cup;
import com.java.class13.generic.Juice;
import com.java.class13.generic.Smoothie;

public class GenericTest {

	public static void main(String[] args) {
		Cup<Beverage> cup = new Cup<>();
		
		Juice juice = new Juice();
		juice.setName("토마토 주스");
		cup.setBeverage(juice);
		System.out.println(cup.getBeverage().getName());
		
		Smoothie straw = new Smoothie();
		straw.setName("딸기스무디");
		cup.setBeverage(straw);
		System.out.println(cup.getBeverage().getName());
		
		Coffee coffee = new Coffee();
		// cup.setBeverage(coffee);
	}

}
