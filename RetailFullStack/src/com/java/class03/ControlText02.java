package com.java.class03;
import java.util.Scanner;

public class ControlText02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		int score = in.nextInt();
		String grade = null;
		
		if(score >= 90) {
			if(score >= 96){
				grade = "A+";
			} else {
				grade = "A0";
			}
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else if (score < 60) {
			grade = "F";
		}
		System.out.printf("당신의 학점은 %s", grade);
	}

	boolean x = true;
}
