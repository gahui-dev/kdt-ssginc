package com.java.class07;

public class StringTest01 {
	public static void main(String[] args) {
		String str1 = "안녕 자바";
		String str2 = "안녕 자바";
		System.out.println(str1 == str2);
		
		String str3 = str1;
		System.out.println(str3 == str2);
		
		String str4 = new String("안녕 자바");
		System.out.println(str3 == str4);
		
		String str5 = "안녕 자바";
		System.out.println(str5 == str1);
		System.out.println(str5 == str4);
	}
}
