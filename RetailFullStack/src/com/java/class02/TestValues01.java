package com.java.class02;

public class TestValues01 {

	public static void main(String[] args) {
		int weight;
		int total;
		double avg;
		int member = 0;
		
		weight = 80; // 60, 50, 90
		
		total = 0;
		total = total + weight;
		member = member + 1;
		
		weight = 60;
		total = total + weight;
		member = member + 1;
		
		weight = 50;
		total = total + weight;
		member = member + 1;
		
		weight = 90;
		total = total + weight;
		member = member + 1;
		
		// 총 몸무게
		System.out.println("총 몸무게 : " + total);
		
		avg = (double)total / member;
		
		// 평균 몸무게 출력
		System.out.println("평균 몸무게: " + avg);
		
	}

}
