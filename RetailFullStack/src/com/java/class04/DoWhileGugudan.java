package com.java.class04;

public class DoWhileGugudan {
	public static void main(String[] args) {
		int preNum = 2;
		int postNum;
		
		do {
			postNum = 1;
			
			do {
				System.out.printf("%d\t", preNum * postNum);
				postNum++;			
				
			}while(postNum < 10);
			
			System.out.println("\n");
			preNum++;
			
		} while(preNum < 10);
	}
}	

