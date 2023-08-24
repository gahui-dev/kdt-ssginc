package com.java.class05;

import java.util.Scanner;

public class ControlTest02 {

	public static void main(String[] args) {
		// switch문
		// A(>=90), B(80~90), C(70~80), D(60~70), F(<60)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하세요> ");
		int korean = sc.nextInt();
		System.out.print("영어 점수를 입력하세요> ");
		int english = sc.nextInt();
		System.out.print("수학 점수를 입력하세요> ");
		int math = sc.nextInt();
		System.out.print("과학 점수를 입력하세요> ");
		int science = sc.nextInt();
		
		double avg = (double)(korean + english + math + science) / 4;
		int total = (int)(avg / 10);
		String grade = "";
		
		switch(total) {
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
		System.out.println("평균은 " + avg + "점이고, " + grade + "학점입니다");	
		
	}

}
