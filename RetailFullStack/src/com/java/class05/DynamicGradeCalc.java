package com.java.class05;

import java.util.Scanner;

public class DynamicGradeCalc {
	public static void main(String[] args) {
		// 몇 과목 입력받을지
		// 국어, 영어, 수학, 과학 ...기타 과목
		// 출력 => 평균, 몇과목, 몇학점
		Scanner sc = new Scanner(System.in);
		String subject = "";
		
		System.out.println("몇 과목 입력하실건가요? ");
		int numSubject = sc.nextInt(); // 과목 수
		int cntSubject; // 카운트
		int amount = 0; // 총 점수

		for(cntSubject = 0; cntSubject < numSubject; cntSubject++) {
			switch(cntSubject) {
			case 0: subject = "국어"; break;
			case 1: subject = "영어"; break;
			case 2: subject = "수학"; break;
			case 3: subject = "과학"; break;
			default: subject = "기타";
			}
			
			System.out.print(subject + " 점수 입력 > ");
			amount += sc.nextInt();
			
		}
		
		double avg = (double)amount / numSubject;
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
		
		System.out.println(numSubject + "과목의 평균은 " + avg + "점, 학점은" + grade + "입니다.");
		
		
	}
}
