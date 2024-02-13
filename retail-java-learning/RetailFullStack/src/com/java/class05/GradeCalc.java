package com.java.class05;

import java.util.Scanner;

public class GradeCalc {

	public static void main(String[] args) {
		// 학점 계산하기
		Scanner sc = new Scanner(System.in);
		int endSubject = 4;
		String subject = "";
		int totalScore = 0;

		for(int cntSubject = 0; cntSubject < endSubject; cntSubject++) {
			// 1번 구간
			switch(cntSubject) {
			case 0: subject="국어"; break;
			case 1: subject="영어"; break;
			case 2: subject="수학"; break;
			case 3: subject="과학"; break;
			}

			// 입력
			System.out.print(subject + " 점수 입력 > ");

			// 점수 누적
			totalScore += sc.nextInt();
			// System.out.println("누적 점수 > " + totalScore);			
		}
		// 평균
		double avg = (double)totalScore / endSubject;
		int score = (int) (avg / 10);
		String grade = "";

		switch(score) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8: 
			grade = "B";
			break;
		case 7: 
			grade = "C";
			break;
		case 6: 
			grade = "D";
			break;
		default: 
			grade = "F";
		}
		
		System.out.println("평균은 " + avg + "점, 학점은" + grade + "입니다.");

	}

}
