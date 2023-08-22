package com.java.class03;

public class gugudan {

	public static void main(String[] args) {
		int pre = 2;  // 2~9
		int post; // 1~9
		
		while(pre < 10) {			
			post = 1;
			
			while(post < 10) {
				System.out.printf("%d\t", pre * post);
				post++;
			}
			pre++;
			System.out.println("\n");
		}
	}

}
