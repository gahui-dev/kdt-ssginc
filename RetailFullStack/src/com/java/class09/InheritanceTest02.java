package com.java.class09;
import com.java.class09.test02.*;

public class InheritanceTest02 {

	public static void main(String[] args) {
		Eagle eagle = new Eagle("독수리");
		Tiger tiger = new Tiger("호랑이");
		GoldFish goldFish = new GoldFish("금붕어");
		
		eagle.먹다();
		eagle.잠자다();
		eagle.이동하다();
		System.out.println();
		tiger.먹다();
		tiger.잠자다();
		tiger.이동하다();
		System.out.println();
		goldFish.먹다();
		goldFish.잠자다();
		goldFish.이동하다();
		System.out.println();
		
		// 접근 지정자 default, private, public
		// 다른 패키지 public o, default x, private x, (protected x, protected 상속되어 있는 객체 o)
		// 같은 패키지 public o, default o, private x, protected o 
		// public > protected > default > private
		System.out.println(eagle.toString());
		eagle.이동하다();
		
	}
}
