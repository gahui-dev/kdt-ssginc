package com.java.class07;

public class StringTest03 {
	public static void main(String[] args) {
		String str1 = new String("안녕 자바야");
		// 리터럴 값 => 시스템에게 맡길 때(JVM)
		String str2 = "안녕 자바야 나는 가희야 ";
		String str3 = "Hello java";
		
		System.out.println("charAt() : index가 지정한 문자열 반환 \n> " + str2.charAt(3));
		System.out.println("concat() : 주어진 문자열 s를 현재 문자열 뒤에 연결 \n>" + str2.concat("안녕 자바야"));
		System.out.println("contains() : 문자열 s를 포함하는지 조사 \n>" + str2.contains("나는"));
		System.out.println("endsWith() : 끝나는 문자열이 s인지 조사 \n>" + str2.endsWith("야"));
		System.out.println("indexOf() : 문자열 s가 나타난 위치를 반환 \n>" + str2.indexOf("자바"));
		System.out.println("isBlack() : 길이가 0 혹은 공백 있으면 true 반환 \n>" + str2.isBlank());
		System.out.println("isEmpty() : 길이가 0 이면 true 반환 \n>" + str2.isEmpty());
		System.out.println("length() : 길이를 반환 \n>" + str2.length());
		System.out.println("repeat() : c번 반복한 문자열 반환 \n>" + str2.repeat(3));
		System.out.println("startsWith() : 시작하는 문자열이 s인지 조사 \n>" + str2.startsWith("녕"));
		System.out.println("substring() : index부터 시작하는 문자열의 일부를 반환 \n>" + str2.substring(7));
		System.out.println("toLowerCase() : 모두 소문자로 변환 \n>" + str3.toLowerCase());
		System.out.println("toUpperCase() : 모두 대문자로 변환 \n>" + str3.toUpperCase());
		System.out.println("trim() : 앞뒤에 있는 공백을 제거한 후 반환 \n>" + str2.trim());
	}
}
