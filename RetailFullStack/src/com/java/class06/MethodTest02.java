package com.java.class06;

import java.util.Scanner;

public class MethodTest02 {
	// 두 수를 입력받아서 큰 수를 넘겨주기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자를 몇개 입력받을까요? (2~3) >");
			int count = sc.nextInt();
			
			if(count == 2) {
				
			} else if (count == 3) {
				
			} else {
				System.out.println("다시 입력해주세요");
				break;
			}
			int number1 = inputNumber(sc, "첫 번째 숫자를 입력해주세요> " );
			int number2 = inputNumber(sc, "두 번째 숫자를 입력해주세요> ");
			int number3 = inputNumber(sc, "세 번째 숫자를 입력해주세요> ");
			printMessage(number1, number2, number3);
		}
		
	}
	
	public static int inputNumber(Scanner sc, String message) {
		System.out.println(message);
		return sc.nextInt();
	}
	
	public static int getMax(int number1, int number2) {
		int result = number1 > number2 ? number1 : number2;
		return result;
	}
	
	public static int getMax(int number1, int number2, int number3) {
		int result = getMax(getMax(number1, number2), number3);
		return result;
	}
	
	public static void printMessage(int number1, int number2) {
		System.out.printf("max : (%d, %d) : %d",
				number1, number2, getMax(number1, number2) );
	}
	
	public static void printMessage(int number1, int number2, int number3) {
		System.out.printf("max : (%d, %d, %d) : %d", 
				number1, number2, number3, getMax(number1, number2, number3) );
	}
}
