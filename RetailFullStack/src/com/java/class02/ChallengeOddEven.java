package com.java.class02;
import java.util.Scanner;

public class ChallengeOddEven {

	public static void main(String[] args) {
		int number;
		String result;
		
		Scanner in = new Scanner(System.in);
		System.out.println("정수를 입력하세요: ");
		number = in.nextInt();

		result = number % 2 == 0 ? "짝수" : "홀수" ;
		System.out.println(result);
		
	}

}
