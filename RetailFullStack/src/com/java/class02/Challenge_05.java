package com.java.class02;

public class Challenge_05 {

	public static void main(String[] args) {
		// 임의의 소문자로 초기화된 char 타입 변수 c를 대문자로 변환해 출력하는 프로그램을 작성하라
		char c = 'c';
		int gap = (int)'A' - (int)'a';
		
		System.out.println((char)((int)c + gap));

	}

}
