package com.java.class03;

import java.util.Scanner;

public class OperatorTest01 {
	public static void main(String[] args) {
//		byte shift = -126;
//		byte shiftResult = (byte)(shift >> 1);
//		shiftResult = -126 >> 1;
//		System.out.println(-126);
//		System.out.println(-126 >> 1);
//		System.out.println(-126 >>> 1);
//		
//		
//		System.out.println(Integer.toBinaryString(-126));
//		System.out.println(Integer.toBinaryString(-126 >> 1));
//		System.out.println(Integer.toBinaryString(-126 >>> 1));
		
		// 문제 1 절차
		int x, y, z, i = 10000;
		x = y = z = i++;
		// z = i;   => z = 10000
		// i = i+1; => i = 10001
		// y = z;   => y = 10000
		// x = y;   => x = 10000
		System.out.println(x);
		
		// 문제2
		x = 2; y = 3; z =4;
		z += x++ + --y * x;
		
		// int tmp = x; // 1. 후위 처리 => 백업
		// x = x+1;     // 2. 증가 시킴 
		// y = y-1;		// 3. 전위 처리
		// a = tmp + y * x;  // 4. y*x 수행, tmp 수행
		// z = z + a; 		 // 5. 대입 연산자 수행
		
		System.out.println(z);
		
		
		// 문제3 - 받은 정수 제곱 값 출력
//		System.out.println("문제3. 받은 정수 제곱 값 출력");
//		Scanner sc = new Scanner(System.in);
//		int number;
//		
//		System.out.print("정수를 입력하세요 : " );
//		number = sc.nextInt();
//		System.out.printf("%d의 제곱> %d\n\n", number, number*number);
//		
		
		// 문제4 - 원기둥 부피 구하기
//		System.out.println("문제4. 원기둥 부피 구하기");
//		int radius, height;
//		final double PI = 3.14;
//		double volume;
//		
//		System.out.print("원기둥의 밑면 반지름은? ");
//		radius = sc.nextInt();
//		System.out.print("원기둥의 높이는? ");
//		height = sc.nextInt();
//		
//		volume = PI * radius * radius * height;
//		System.out.println("원기둥의 부피는"+ volume );
		
		// 문제3 키보드로 입력받아서 처리하시오.
		// 받은 정수의 제곱 값을 출력하시오
		// 정수 입력>7
		// 7의 제곱>49
		Scanner in = new Scanner(System.in);
		System.out.print("정수 입력>");
		int input = in.nextInt();
		int result = input * input;
		System.out.printf("%d의 제곱>%d", input, result);


		// 문제4 (마지막) 반지름 * 반지름 * 높이 * 3.14
		// 원기둥의 밑면 반지름 입력>10
		// 원기둥의 높이 입력>10
		// 원기둥의 부피 결과>3140.0
		System.out.println();
		System.out.print("원기둥의 밑면 반지름 입력>");
		double radius = in.nextDouble();
		System.out.print("원기둥의 높이 입력>");
		double height = in.nextDouble();
		double resultDouble = radius * radius * height * Math.PI;
		System.out.printf("원기둥의 부피 결과>" + resultDouble);
	}
}
