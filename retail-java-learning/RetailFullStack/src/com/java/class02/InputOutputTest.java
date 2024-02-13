package com.java.class02;

import java.util.Scanner;

public class InputOutputTest {
	public static void main(String[] args) {
		System.out.println("메롱");
		System.out.print(true);
		System.out.print(13);
		System.out.print(14);
		System.out.print('A');
		System.out.println();
		System.out.println();
		System.out.print("\n");
		System.out.print("\t\t");
		System.out.println(30);
		System.out.printf("정수형 %d 숫자입니다", 15);
		
		System.out.println("\n---------------------------");
		Scanner in = new Scanner(System.in);
		
		System.out.print("입력> ");
		int input = in.nextInt();
		System.out.printf("입력하신 숫자는 %d", input);
		
		System.out.print("\n입력> ");
		double dInput = in.nextDouble();
		System.out.printf("입력하신 숫자는 %2.1f", dInput);
	}
}
