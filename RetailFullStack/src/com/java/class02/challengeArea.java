package com.java.class02;

import java.util.Scanner;

public class challengeArea {

	public static void main(String[] args) {
		double w, h, area;
		Scanner in = new Scanner(System.in);
		
		System.out.print("직사각형의 가로 길이를 입력하세요: ");
		w = in.nextDouble();
		
		System.out.print("직사각형의 세로 길이를 입력하세요: ");
		h = in.nextDouble();
		
		area = w * h;
		System.out.printf("직사각형의 넓이는 %2.1f 입니다.", area);
	}
}
