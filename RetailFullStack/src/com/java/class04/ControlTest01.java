package com.java.class04;

public class ControlTest01 {
	public static void main(String[] args) {
		int x = 10;		

		while( x < 10) {
			System.out.println("while - " + x);
			x++;
		}
		
		x = 10;
		do {
			System.out.println("do while - " + x);
			x++;
		} while(x < 10);
		
		int pre = 2;  // 2~9
		int post; // 1~9
		
//		while(pre < 10) {			
//			post = 1;
//			
//			while(post < 10) {
//				System.out.printf("%d\t", pre * post);
//				post++;
//			}
//			pre++;
//			System.out.println("\n");
//		}
		
		do {
			post = 1;
			while(post < 10) {				
				System.out.printf("%d\t", pre * post);
				post++;			
			}
			pre++;
			System.out.println("\n");
			
		} while(pre < 10);
	}

}
