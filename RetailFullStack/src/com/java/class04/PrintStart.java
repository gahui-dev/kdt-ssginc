package com.java.class04;

public class PrintStart {
	public static void main(String[] args) {
		System.out.println("문제1 ----------------------");
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		
		System.out.println("\n문제2 ----------------------");
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
		System.out.println("\n문제3 ----------------------");
		for(int i = 5; i >= 1 ; i--) {
			for(int j = 1; j <= i ; j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		
		System.out.println("\n문제4 ----------------------");
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j <= 5 - i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		System.out.println("\n문제5 ----------------------");
		int line = 5;
        for (int i = line; i >= 1; i--) {
        	for (int j = 0; j < line - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
		System.out.println("\n문제6 ----------------------");
		int count = 1;
		
		for(int i = 8; i >= 0 ; i--) {
			int j = i - 4;
			
			if(i >= 4) {
				for(; j >= 0; j--) {
					System.out.print(" ");					
				}
				for(int k = 0; k < count; k++) {
					System.out.print("*");
				}
			} else {
				for(; j <= 0; j++) {
					System.out.print(" ");					
				}
				for(int k = 0; k < count; k++) {
					System.out.print("*");
				}
			}
			
			if(i > 4) {
				count += 2;				
			} else {
				count -= 2;
			}
			
			System.out.println();
		}
		
	}
}

