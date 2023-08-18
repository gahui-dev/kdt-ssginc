package com.java.class01;

// 기본 구조
// 클래스 선언
// class명은 첫글자 대문자 법칙
public class Hello {
	// 멤버 변수
	String hello = "안녕";

	// 생성자
	// 멤버 메서드
	public void printHello() {
		System.out.println(hello + ", 나는 지금 풀스택 과정 듣고있어! 너는?");
	}

	public static void main(String[] args) {
		System.out.println("Hello Java");
		Hello hello = new Hello();
		hello.printHello();
		
		// 식별자
		// 단어가 하나일 때, 변수명 메서드 명 => 소문자 시작
		// 복합 문자 => Camel 기법
		
		// 변수 선언
		// 타입 " " 변수명 
		boolean isNaverFlagEmailYes = true;
		final int NUMBER_FLAG_NAVER_NEWS = 1;
		final int NUMBER_FLAG_NAVER_SPORTS = 2;
		final int NUMBER_FLAG_NAVER_MUSIC = 3;
		
		/*
		 여러줄 주석
		 */
		/**
		 javadoc
		 */
	}

}
