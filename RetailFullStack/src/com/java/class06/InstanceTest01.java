package com.java.class06;

public class InstanceTest01 {

	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		lamp.printStatusOfLamp();
		
		lamp.turnOn();
		lamp.printStatusOfLamp();
		
		lamp.turnOff();
		lamp.printStatusOfLamp();
		
		// 클래스 타입으로 객체를 만들어냄
		//Car myCar = new Car();
		//myCar.setSpeed(60);
		//myCar.setDirection(Car.DIRECTION_GO);
		//myCar.display();
		
		//myCar.setSpeed(-40);
		//myCar.setDirection(Car.DIRECTION_LEFT);
		//myCar.display();
		
		//myCar.setSpeed(80);
		//myCar.setDirection(Car.DIRECTION_RIGHT);
		//myCar.display();
		
		// 객체 생성하고 사용하기
		// 객체의 주소정보를 담을 변수(붕어빵1) 선언
		// 변수(붕어빵1)에 new 연산자를 이용하여 객체 생성?
		// 변수(붕어빵1)을 통해 멤버변수(ingredient)와 메서드(display)에 접근하여 사용
		
		붕어빵틀 붕어빵1 = new 붕어빵틀();
		붕어빵1.ingredient = "앙꼬";
		붕어빵1.display();
		System.out.println(붕어빵1);
		
		붕어빵틀 붕어빵2 = new 붕어빵틀();
		붕어빵2.ingredient = "바닐라";
		붕어빵2.display();
		System.out.println(붕어빵2);
		
		
		붕어빵틀 붕어빵3 = new 붕어빵틀();
		붕어빵3.ingredient = "크림";
		붕어빵3.display();
		System.out.println(붕어빵3);
	}

}
