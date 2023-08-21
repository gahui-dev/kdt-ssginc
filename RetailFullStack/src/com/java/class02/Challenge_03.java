package com.java.class02;
import java.util.Scanner;

public class Challenge_03 {

	public static void main(String[] args) {
		// 3. 원기둥의 부피를 구하는 프로그램을 작성하라
		Scanner sc = new Scanner(System.in);
		int radius, height;
		final double PI = 3.14;
		double volume;
		
		System.out.print("원기둥의 밑면 반지름은? ");
		radius = sc.nextInt();
		System.out.print("원기둥의 높이는? ");
		height = sc.nextInt();
		
		volume = PI * radius * radius * height;
		System.out.println("원기둥의 부피는"+ volume );

	}

}
