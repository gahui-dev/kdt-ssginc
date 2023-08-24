package com.java.class05;

import java.util.Scanner;

public class MethodTest02 {
	// 정수 입력 받아서 홀짝을 알려주는 프로그램
	// 13 입력 => 프로그램 종료할지 (0: 취소, 1: 종료), 다른 수 입력 시 1과 0만 입력가능 알려주기


	// 접근지정자 static 반환타입 메서드명 (매개변수 목록)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("정수를 입력하세요(13: 종료) > ");		
			int number = sc.nextInt();
			
			if(number != 13) {
				getOddEvens(number);
				String result = getOddEvens(number);
				System.out.println("입력하신 정수 " + number + "은 " + result + "입니다.");
			} else {
				int result = confirmCancel(sc);
				if(result == 1) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("프로그램을 다시 진행합니다.");
				}
			}
		}		
	}
	
	// 짝수 or 홀수
	public static String getOddEvens(int number) {
		String result = number % 2 == 0 ? "짝수" : "홀수";
		return result;
	}
	
	// 취소 or 종료
	public static int confirmCancel(Scanner sc) {
		int result;
		boolean resultCheck;
		do {
			System.out.print("프로그램을 종료하시겠습니까? (0: 취소, 1: 종료)");
			result = sc.nextInt();
			resultCheck = result != 0 && result != 1;
			
			if(resultCheck) {
				System.out.println("잘못 입력했습니다. 다시 입력해주세요. (0: 취소, 1: 종료)");
			}
		} while (resultCheck);
		
		return result;
	}

}
