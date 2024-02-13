package com.java.class08;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.class07.People;

public class ArrayList02 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int i = 0 ; i < 100; i++) {
			arrayList.add(i);
		}
		arrayList.remove(11);
		
		System.out.println("ArrayList<Integer> => " + arrayList.toString() + "\n");
		
		IntegerList intList = new IntegerList();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			intList.add(i);
		}
		
		while(true) {
			System.out.println("현재 배열 크기 > " + intList.array.length);
			System.out.print("현재 배열 상태 > ");
			intList.toString();
			System.out.print("배열에 추가할 정수를 입력해주세요(-1: 종료) > ");
			int inputData = sc.nextInt();
			if(inputData == -1) {
				System.out.println("종료되었습니다.");
				break;
			}
			intList.add(inputData);
		}
	}
}
