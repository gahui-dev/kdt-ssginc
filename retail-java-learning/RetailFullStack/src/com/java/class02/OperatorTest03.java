package com.java.class02;

public class OperatorTest03 {

	public static void main(String[] args) {
		// 증감
		// ++, --
		// 전위, 후위
		int number = 0;
		
		// 후위 연산자
		int total = number++;
		System.out.println("후위 연산자 테스트");
		System.out.print("total, number = ");
		System.out.println(total + ", " + number);
		
		total = 0;
		number = 0;
		total = number;
		number = number + 1;
		System.out.print("total, number = ");
		System.out.println(total + ", " + number);
		
		// 전위 연산자
		total = 0;
		number = 0;
		total = ++number;
		System.out.println("전위 연산자 테스트");
		System.out.print("total, number = ");
		System.out.println(total + ", " + number);
		
		
		total = 0;
		number = 0;
		number = number + 1;
		total = number;
		System.out.print("total, number = ");
		System.out.println(total + ", " + number);
	}

}
