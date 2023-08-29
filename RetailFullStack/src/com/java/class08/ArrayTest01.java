package com.java.class08;

import java.util.ArrayList;

import com.java.class07.People;

public class ArrayTest01 {
	public static void main(String[] args) {
		// 객체 생성
		People people = new People();
		
		// 배열 객체 생성
		People[] peopleArray = new People[4];
		int[] array = new int[4];
		
		System.out.println(peopleArray[0]);
		peopleArray[0] = new People();
		
		// 동적 배열
		ArrayList<People> peopleList = new ArrayList<People>();
		people = new People();
		peopleList.add(people);
		
		System.out.println(people);
		System.out.println(peopleList.get(0));
		people = null;
		System.out.println(people);
		System.out.println(peopleList.get(0));
		
		People[] peopleArray2 = new People[3];
		peopleArray = peopleArray2;
		System.out.println(peopleArray);
		System.out.println(peopleArray2);
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		IntegerList intList = new IntegerList();
		
		for(int i = 0 ; i < 100; i++) {
			arrayList.add(i);
		}
		System.out.println(arrayList.toString());
		System.out.println(intList.toString());
	}
}
