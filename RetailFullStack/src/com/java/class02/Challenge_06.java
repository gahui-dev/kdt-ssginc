package com.java.class02;
import java.util.Scanner;

public class Challenge_06 {
	public static void Main(String[] args) {
		// 키보드로 화씨온도를 입력받아 섭씨온도로 환산해 출력하는 프로그램
		double f, c;
		Scanner sc = new Scanner(System.in);
		System.out.print("화씨 온도를 입력하세요 : ");
		f = sc.nextDouble();
		c = 5 / 9 *(f - 32);
		System.out.printf("화씨 온도 %d도는 섭씨 온도로 %d도입니다.", f, c);
	}
}
