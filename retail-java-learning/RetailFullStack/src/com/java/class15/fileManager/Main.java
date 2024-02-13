package com.java.class15.fileManager;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("로그인이 필요한 프로그램입니다. [1] 로그인 [2] 회원가입 [0] 프로그램 종료 >> ");

			int select = sc.nextInt();
			sc.nextLine();

			switch(select) {
			case 1:
				if(DatabaseManager.loginUser(sc)) {
					FileManager.fileManagement(sc);
				} else {
					System.out.println("사용자 계정 정보가 일치하지 않습니다. ");
				}				
				break;
			case 2:
				DatabaseManager.registerUser(sc);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("다시 선택해주세요.");
			}
		}
	}
}
