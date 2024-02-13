package com.java.class12;

import java.util.Scanner;

public class ExceptionTest03 {

	public static void main(String[] args) {
		// 예전 방식
//		Scanner scanner = new Scanner(System.in);
//		
//		try {
//			int input = scanner.nextInt();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(scanner != null) {
//				try {
//					scanner.close();
//					scanner = null;
//				} catch(Exception e) {}				
//			}
//		}
		
		try(Scanner scanner = new Scanner(System.in);) {
			int input = scanner.nextInt();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
