package com.java.class09;

import com.java.class09.test02.*;

public class InheritanceTest03 {

	public static void main(String[] args) {
		Animal animal; // 부모
		
		Eagle eagle = new Eagle("독수리");
		Tiger tiger = new Tiger("호랑이");
		GoldFish fish = new GoldFish("금붕어");

		animal = eagle;
		animal.먹다();
		animal.잠자다();
		animal.이동하다();
		
		animal = tiger;
		animal.먹다();
		animal.잠자다();
		animal.이동하다();
		
		animal = fish;
		animal.먹다();
		animal.잠자다();
		animal.이동하다();
		
		Object object = animal;

		object = new Eagle("독수리2");
		
		animal = eagle;
		animal.이동하다();
		eagle = (Eagle)animal;
		eagle.이동하다();
		animal = new Tiger("타이거2");
		Tiger tiger2 = (Tiger)animal;
		tiger2.이동하다();
	}

}
