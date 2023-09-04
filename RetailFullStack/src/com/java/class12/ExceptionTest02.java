package com.java.class12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest02 {

	public static void main(String[] args) {
		// Object
		//   |
		// Throwable
		//   |
		// Error
		//   |
		// VirtualMachineError
		//   |
		// StackOverflowError
		
		// StackOverflowError
		//System.out.println("test");
		//ExceptionTest02.main(args);

		int input = 0;
		while(true) {
			Scanner sc = null;
			try {
				sc = new Scanner(System.in);
				System.out.print("정수를 입력해주세요 > ");
				input = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println("정수만 입력가능합니다. ");
			} finally {
				if(sc != null) sc = null;
			}
		}
		
//		while(true) {
//			try(Scanner sc = new Scanner(System.in)) {
//				System.out.print("정수를 입력해주세요 > ");
//				input = sc.nextInt();
//				break;
//			} catch(InputMismatchException e) {
//				System.out.println("정수만 입력가능합니다. ");
//			}
//		}
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.print("점수를 입력해주세요 > ");
				input = sc.nextInt();
				if(input < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch(InputMismatchException e) {
				System.out.println("정수만 입력가능합니다. ");
				sc = null;
				sc = new Scanner(System.in); 
			} catch(IllegalArgumentException e) {
				System.out.println("점수는 양수만 입력하세요");
				sc = null;
				sc = new Scanner(System.in); 
			}
		}
		
		System.out.println("입력하신 정수는 " + input + "입니다. ");
	}

}
