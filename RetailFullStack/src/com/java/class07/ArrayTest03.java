package com.java.class07;

import java.util.Scanner;

public class ArrayTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int peopleCount = getCount(sc, "몇 명의 인원이 있나요? > ");
		People[] people = new People[peopleCount];
		
		// 점수 입력
		for(int i = 0; i < peopleCount; i++) {
			String name = getName(sc, "이름은 무엇인가요? ");
			int subjectCount = getCount(sc, "몇 과목 입력하실건가요? > ");

			people[i] = new People(name, subjectCount);
			inputScores(sc, people[i], subjectCount);
			System.out.println();
		}
		
		// 점수, 총점, 평균 출력
		for (int i = 0; i < people.length; i++) {
			System.out.print(people[i].name + "님의 점수 > ");
			printScores(people[i]);
			System.out.println();
		}
	}
	
	public static int getCount(Scanner sc, String message) {
		System.out.print(message);
		int count = sc.nextInt();
		sc.nextLine();
		return count;
	}
	
	public static String getName(Scanner sc, String message) {
		System.out.print(message);
		String name = sc.nextLine();
		return name;
	}
	
	public static void inputScores(Scanner sc, People people, int subjectCount) {
		for(int i = 0; i < subjectCount; i++) {
			System.out.printf((i + 1) + "번째 과목 점수 입력 > ");
			int score = sc.nextInt();
			sc.nextLine();
			people.scores[i] = score;
		}
	}
	
	public static void printScores(People people) {
		int totalScore = 0;
		for(int i = 0; i < people.scores.length; i++) {
			System.out.print(people.scores[i] + "점 ");
			totalScore += people.scores[i];
		}
		double avgScore = (double)totalScore / people.scores.length;
		System.out.println("\n총점: " + totalScore);
		System.out.println("평균: " + String.format("%.2f", avgScore));
	}
}






