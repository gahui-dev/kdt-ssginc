package com.java.class12.demo;
import java.io.*;

public class TryWithResource {

	public static void main(String[] args) {
		// try-with-resource - 자동 리소스 관리
		// try 괄호 안에 필요한 리소스 선언 => try 키워드 다음에 소괄호가 있으면 리소스로 취급
		// 생성된 리소스는 블록의 끝에서 자동으로 닫힘
		
		try (FileReader fr = new FileReader("test.txt")) {
			char[] a = new char[50];
			fr.read(a);
			for(char c : a) {
				System.out.print(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
