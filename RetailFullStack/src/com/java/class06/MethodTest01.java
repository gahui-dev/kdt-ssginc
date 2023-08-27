package com.java.class06;

import java.util.Scanner;

public class MethodTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 합(x~n) : total
		// 13 입력 => 프로그램 종료 묻기(종료:1, 취소:0)
		
		
		while(true) {
			System.out.println("두 수 사이의 합을 구하는 프로그램입니다. (13: 종료)");

			int startNum = numberInput(sc, "첫 번째 숫자를 입력하세요> ");
			if(startNum == 13) {
				if(confirmCancel(sc) == 1) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					startNum = numberInput(sc, "첫 번째 숫자를 입력하세요> ");
				}
			}
			
			int endNum = numberInput(sc, "두 번째 숫자를 입력하세요> ");
			if(endNum == 13) {
				if(confirmCancel(sc) == 1) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					endNum = numberInput(sc, "첫 번째 숫자를 입력하세요> ");
				}
			}
			
			int total = calculateNumbersAndReturnTotal(startNum, endNum);
            System.out.printf("합(%d ~ %d) : %d\n", startNum, endNum, total);
		}
	}
	
	
	public static int numberInput(Scanner sc, String message) {
		System.out.println(message);
		return sc.nextInt();
	}
	
	
	public static int confirmCancel(Scanner sc) {
		int result;
		boolean resultCheck;
		do {
			System.out.print("프로그램을 종료하시겠습니까? > (0: 취소, 1: 종료)");
			result = sc.nextInt();
			resultCheck = result != 0 && result != 1;
			
			if(result == 1) {
				System.out.println("프로그램을 종료합니다.");
			} else if(result == 0) {
				
			}
			
			if(resultCheck) {
				System.out.println("잘못 입력했습니다. 다시 입력해주세요. (0: 취소, 1: 종료)");
			} 
		} while (resultCheck);
		
		return result;
	}
	
	
	public static int calculateNumbersAndReturnTotal(int startNum, int endNum) {
		int total = 0;
		for(int start  = startNum; start <= endNum; start++) {
			total += start;
		}
		
		return total;
	}
}
