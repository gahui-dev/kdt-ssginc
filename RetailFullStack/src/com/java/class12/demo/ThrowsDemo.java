package com.java.class12.demo;

import java.util.Scanner;

public class ThrowsDemo {

	public static void main(String[] args) {
		System.out.print("숫자를 입력해주세요 > ");
		Scanner sc = new Scanner(System.in);
		
		// square() 메서드에서 예외가 발생하면 스스로 처리하지 않고 여기서 처리
		try {
			square(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("정수가 아닙니다.");
		}
	}
	
	// 호출한 메서드에서 예외를 처리하도록 떠넘김
	public static void square(String s) throws NumberFormatException {
		int n = Integer.parseInt(s);
		System.out.println(n * n);
	}
}
