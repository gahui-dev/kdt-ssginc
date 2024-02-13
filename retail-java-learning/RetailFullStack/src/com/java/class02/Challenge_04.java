package com.java.class02;
import java.util.Scanner;

public class Challenge_04 {

	public static void main(String[] args) {
		// 초를 입력하면 시간, 분, 초로 환산해 출력하는 프로그램을 작성하라
		Scanner sc = new Scanner(System.in);
		System.out.print("초 단위 정수를 입력하세요: ");
		int second = sc.nextInt();
		
		// 시간 = 분/60, 분 = 초/60, 초 = 초%60
		int minute = second / 60;
		int hour = minute / 60;
		second = second % 60;
		
		
		System.out.printf("%d시간 %d분 %d초", hour, minute, second);
	}

}
