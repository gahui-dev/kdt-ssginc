package com.java.class12.demo;

public class TryCatch1Demo {
	public static void main(String[] args) {
		int[] array = {0, 1, 2};
		
		try {
			// array는 3개의 원소만 있으므로 예외 발생
			System.out.println("마지막 원소 => " + array[3]);
			// 이전 실행문에서 예외가 발생했으므로 실행하지 않음ㄴ
			System.out.println("첫 번째 원소 => " + array[0]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("원소가 존재하지 않습니다.");
		}
		
		System.out.println("어이쿠");
	}
}
