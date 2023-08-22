package com.java.class03;
import java.util.Scanner;


public class ControlTest {

	public static void main(String[] args) {
		int x= -200;
		boolean result = false;
		
		if(x > 1 || x < -100) {
			System.out.println("-100보다 작거나 1보다 크네요 :)");
		}
		
		Scanner sc = new Scanner(System.in);
		int number;
		
		System.out.print("숫자를 입력하세요: ");
		number = sc.nextInt();
		
		if(number % 2 == 0) {
			System.out.println("짝수!");
		} else {
			System.out.println("홀수!");
		}	
		
		
		System.out.print("점수를 입력하세요: ");
		int score = sc.nextInt();
		String grade = null;
		
		if(score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else if (score < 60) {
			grade = "F";
		}
		System.out.println("당신의 학점은" + grade);
		
	}

}
