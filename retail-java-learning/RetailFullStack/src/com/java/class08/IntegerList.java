package com.java.class08;

public class IntegerList {
	int[] array; 
	public int size; // 배열 크기 확인

	public IntegerList() {
		array = new int[5];
		size = 0;
	}

	public boolean add(int value) {
		// 배열이 꽉 차면?
		if (size == array.length) { 
			int[] newArray = new int[array.length + 1];
			
			// 기존 배열 복사
			for (int i = 0; i <array.length; i++) {
				newArray[i] = array[i];
			}
			
			// 새로 만든 배열 대체
			array = newArray;
		}
		array[size] = value;
		size++;
		return true;
	}
	public String toString() {
		System.out.print("[");
		for(int i = 0; i < size; i++) {
			System.out.print(array[i]);
			
			if(i < size - 1) {
				System.out.print(", ");
			}			
		}
		System.out.print("]\n");
		return "";
	}

}
