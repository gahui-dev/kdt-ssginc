package com.java.class03;
import java.util.Scanner;

public class ControlText03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		boolean result = 1 < x;
		
		while(1 < x) {
			System.out.println("실행 확인" + x);
			x--;
		}
		System.out.println("프로그램을 종료합니다");
		
//		 정수를 입력 계속 받기
//		 입력 받은게 짝수라면 ? x--;
//		 입력 받은게 홀수라면? 아무것도안함
//		 짝수를 5번 입력받으면 출력하고 프로그램 종료
		Scanner in = new Scanner(System.in);
		int count = 5;
		
		while(count > 0) {
			System.out.print("정수를 입력하세요: " );
			int input = in.nextInt();
			
			if(input % 2 == 0) {
				System.out.printf("%d: 짝수 %d를 입력하였습니다\n", count, input);
				count--;
			} 			
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		
	}

}
