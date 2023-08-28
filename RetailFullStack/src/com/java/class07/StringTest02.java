package com.java.class07;

public class StringTest02 {
	public static void main(String[] args) {
		String str4 = new String("안녕 자바야");
		String str5 = "안녕 자바야";
		String str6 = str4 + str5;
		
		str6 = str4.concat(str5);
		System.out.println("str6 > "+ str6);
		System.out.println("---------------------");
		
		System.out.println("extractSpecificWord 호출");
		String a = extractSpecificWord("야안", str6);
		String b = extractSpecificWord("녕 ", str6);
		
		
		System.out.println("reverseWordStream 호출");
		b = reverseWordStream(b);
		
		System.out.println("결과 출력");
		System.out.println("1. b + a - '" + b.concat(a) +"'");
		System.out.println("2. b + a - '" + b.trim().concat(a) +"'");
	}
	
	private static String extractSpecificWord(String target, String stream) {
		String result = "";
		
		if(stream.contains(target) ) {
			int indexA = stream.indexOf(target);
			
			System.out.println(indexA);

			result = stream.substring(indexA, indexA + target.length()); 
			System.out.println(result); 
		} else {
			result = "없음";
		}
		
		return result;
	}
	
	private static String reverseWordStream(String stream) {
		String result = "";
		for(int i = stream.length() - 1; i >= 0 ; i--) {
			result += stream.charAt(i);
		}
		return result;
	}
	
	// jdk15버전 텍스트 블럭 """ ~ """;
	
}
