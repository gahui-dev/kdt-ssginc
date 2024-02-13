package com.java.class02;

public class OperatorTest03_2 {

	public static void main(String[] args) {
		int total, number = 0;
		
		// total = ++number;
		number = number + 1;
		total = number;
		System.out.printf("전위 연산자 => total : %d, number: %d", total, number);
		
		total = 0;
		number = 0;
		
		// total = number++;
		total = number;
		number = number + 1;
		System.out.printf("\n후위 연산자 => total : %d, number: %d", total, number);
		
		// 증감 대입 연산자
		System.out.println("\n---------------------------");
		System.out.println("증감 대입 연산자");
		System.out.println("---------------------------");
		
		total = 0;
		number = 1;
		
		total += number;
		//total = total + number;
		System.out.printf("+= 연산자 => total : %d, number: %d", total, number);
		
		total = 0;
		number = 1;
		
		total -= number;
		//total = total - number;
		System.out.printf("\n-= 연산자 => total : %d, number: %d", total, number);
		
		// 산술 연산자
		System.out.println("\n---------------------------");
		System.out.println("산술 연산자");
		System.out.println("---------------------------");
		
		total = 7;
		number = 3;
		
		int num = total / number; 
		int rest = total % number; 
		System.out.printf("num: %d, rest: %d\n", num, rest);
		
		System.out.printf("%d\n", num + total);
		
		String str = num + " " + total;
		System.out.println(str);
		
		// > < = >= <=
		// 1 < x < 3, 2
		// 비교 연산자
		System.out.println("\n---------------------------");
		System.out.println("비교 연산자");
		System.out.println("---------------------------");
		
		int x = 2;
		// boolean result = 1 < x;
		System.out.println(1 > x);
		System.out.println(1 < x);
		System.out.println(1 >= x);
		System.out.println(1 <= x);
		System.out.println(1 == x);
		System.out.println(1 == x);
		// 1 not equal x ?
		System.out.println("1 != x => " + (1 != x));
		
		// 비교 연산자
		System.out.println("논리 연산 AND");
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println("논리 연산 OR");
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		// x = 4, 1 < x < 4 false
		x = 4;
		boolean result = (x > 1) && (x < 4);
		System.out.println(result);
		
		// x = 3, 1 < x < 4 true
		x = 3;
		result = (x > 1) && (x < 4);
		System.out.println(result);
		
		x = -10;
		result = (x < 0) || (x > 100);
		System.out.println(result);
		
		x = 100;
		result = (x < 0) || (x > 100);
		System.out.println(result);
		
		x = 1085;
		result = (x < 0) || (x > 100);
		System.out.println(result);
		
		String url = "https://www.naver.com";
		result = url.length() >= 0 && url.length() < 30;
		System.out.println("선교님 문제: " + result);
		
		x = 59;
		result = (x > 100 && x < 1000);
		System.out.println("명진님 문제 1: " + result);
		
		x = 108;
		result = (x > 100 && x < 1000);
		System.out.println("명진님 문제 2: " + result);	
		
		x = 1000;
		result = (x > 100 && x < 1000);
		System.out.println("명진님 문제 3: " + result);		
		
		x = 10008;
		result = (x > 100 && x < 1000);
		System.out.println("명진님 문제 4: " + result);
		
		x = -21;
		result = (x >= -20 && x < 50);
		System.out.println("가희 문제 1: " + result);
		
		x = 30;
		result = (x >= -20 && x < 50);
		System.out.println("가희 문제 2: " + result);
		
		x = 52;
		result = (x >= -20 && x < 50);
		System.out.println("가희 문제 3: " + result);
		
		int a = 30;
		int b = 50;
		result = (b >= a ? true: false);
		System.out.println("정림님 문제: " + result);
		
		System.out.println("비트 연산 OR");
		byte bNum1 = 3;
		byte bNum2 = 4;
		
		byte andResult = (byte)(bNum1 & bNum2);
		byte orResult = (byte)(bNum1 | bNum2);
		
		bNum1 = -125;
		byte xorResult = (byte)(bNum1 ^ bNum2);
		
		System.out.printf("and 결과 %d\n", andResult);
		System.out.printf("or 결과 %d\n", orResult);
		System.out.printf("xor 결과 %d\n", xorResult);
		System.out.printf("^ 결과 %d\n", ~bNum1);
		
		bNum1 = 65;
		byte shiftResult = (byte)(bNum1 << 1);
		System.out.printf("1 << shift 결과 %d\n", shiftResult);
		shiftResult = (byte)(bNum1 << 2);
		System.out.printf("2 << shift 결과 %d\n", shiftResult);
		shiftResult = (byte)(bNum1 << 3);
		System.out.printf("3 << shift 결과 %d\n", shiftResult);
		
		bNum1 = -126;
		shiftResult= (byte)(bNum1 >> 1);
		System.out.printf(">> 결과 %d\n", shiftResult);
		
		bNum1 = -126;
		shiftResult= (byte)(bNum1 >>> 1);
		System.out.printf(">>> 결과 %d\n", shiftResult);
		
		shiftResult= (byte)(bNum1 >> 2);
		System.out.printf("3 shift 결과 %d\n", shiftResult);
		shiftResult= (byte)(bNum1 >> 3);
		System.out.printf("3 shift 결과 %d\n", shiftResult);
		
	}

}
