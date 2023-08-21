package com.java.class02;
import java.util.Scanner;

public class Challenge_02 {

	public static void main(String[] args) {
		// 키보드로 입력받은 정수의 제곱 값을 출력하는 프로그램을 작성하라
		Scanner sc = new Scanner(System.in);
		int number;
		
		System.out.print("정수를 입력하세요 : " );
		number = sc.nextInt();
		System.out.printf("%d의 제곱은 %d", number, number*number);
	}

}
