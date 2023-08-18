package com.java.class01;

public class TypeTest {

	public static void main(String[] args) {
		byte bNum = 120; // 0000 000
		System.out.println(bNum + " => " + Integer.toBinaryString(bNum));
		
		//byte
		bNum = -128;
		System.out.println(bNum + " => " + Integer.toBinaryString(bNum));
		
		bNum = -128 + 1;
		System.out.println(bNum + " => " + Integer.toBinaryString(bNum));
		
		bNum = -128 + 2;
		System.out.println(bNum + " => " + Integer.toBinaryString(bNum));
		
		byte b = 0;
		for(int i = 0; i < 130; i++) {
			b ++;
			System.out.println(b + " - " + Integer.toBinaryString(b));
		}
		
		// 데이터타입 double
		// 변수명 dNum
		// 값 0.0
		double dNum = 0.0;
		float fNum = 0.0f;
		System.out.println(dNum);
		dNum= 1.1;
		System.out.println(dNum);
	}

}
