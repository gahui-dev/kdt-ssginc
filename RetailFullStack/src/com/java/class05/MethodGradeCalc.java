package com.java.class05;

import java.util.Scanner;

public class MethodGradeCalc {

	public static void main(String[] args) {
		// 메서드 사용해서 학점 계산하기
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 과목 입력하나요? ");
		int totalSubject = sc.nextInt();
		
		// 과목별 점수 입력받고 총점 구하기
		int amount = scanSubjectsAndReturnTotalScore(sc, totalSubject);
		// 평균, 등급 구하기
		double avg = (double)amount / totalSubject;
		int score = (int) avg / 10;
		String grade = getGradeByScore(score);

		System.out.println(totalSubject + "과목의 평균은 " + avg + "점으로 " + grade + "학점입니다.");
	}

	// 점수 입력
	public static int scanSubjectsAndReturnTotalScore(Scanner sc, int numSubject) {
		String subject = "";
		int countSubject; // 과목 수 count
		int amount = 0; // 총 점수

		for(countSubject = 0; countSubject < numSubject; countSubject++) {
			subject = classifySubject(countSubject);
			System.out.print(subject + " 점수 입력 > ");
			amount += sc.nextInt();

		}
		return amount;
	}

	// 학점 계산
	public static String getGradeByScore(int score) {
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
		return grade;
	}
	
	public static String classifySubject(int countSubject) {
		String subject = "";
		switch(countSubject) {
		case 0: subject = "국어"; break;
		case 1: subject = "영어"; break;
		case 2: subject = "수학"; break;
		case 3: subject = "과학"; break;
		default: subject = "기타";
		}
		
		return subject;
	}
}
