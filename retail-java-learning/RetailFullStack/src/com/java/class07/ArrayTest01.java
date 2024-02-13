package com.java.class07;
public class ArrayTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 선언1.
		int[] scores = {90, 80, 70, 99};
		String[] grade = {"A", "B", "C", "D"};
		System.out.println(scores);
		
		for(int i = 0; i < scores.length; i++ ) {
			System.out.println(scores[i]);
		}

		// 배열 선언2.
		int scores2[] = new int[] {90, 80, 70, 99};
		
		// 배열 선언3.
		int scores3[];
		// 선언 후 값을 직접 넣는 것 안됨
		// int scores3 = {90, 80, 70, 99};
		scores3 = new int[] {90, 80, 70, 99};
		
		// 배열 선언4.
		int scores4[] = new int[3];
		scores4[0] = 90;
		scores4[1] = 80;
		scores4[2] = 70;
		System.out.println(scores4.length);
	}
}
