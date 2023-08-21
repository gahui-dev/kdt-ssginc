package com.java.class02;

public class TestValues01_2 {
	public static void main(String[] args) {
		int weight;
		double total;
		double avg;
		int member;
		
		total = 0;
		weight = 80;
		total = total + weight;
		
		member = 0;
		member = member + 1;
		
		weight = 62;
		total = total + weight;
		member = member + 1;
		
		weight = 50;
		total = total + weight;
		member = member + 1;
		
		weight = 90;
		total = total + weight;
		member = member +1 ;
		
		avg = total / member;
		
		System.out.println("총 몸무게 - " + total);
		System.out.println("평균 몸무게 - " + avg);
		
		
	}
}
