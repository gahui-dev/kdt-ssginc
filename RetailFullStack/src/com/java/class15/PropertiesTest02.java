package com.java.class15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesTest02 {

	private static final String DEFAULT_PROPERTIES_PATH 
	= Paths.get(File.separator + "Users", "GAHUI", "Documents", "database", "application.ini").toString();

	public static void main(String[] args) {
		System.out.println(DEFAULT_PROPERTIES_PATH);
		Scanner	sc = new Scanner(System.in);
		boolean isLoggedIn = false;

		do {
			System.out.print("아이디를 입력해주세요 >> ");
			String inputUserId = sc.nextLine();
			System.out.print("패스워드를 입력해주세요 >> ");
			String inputUserPwd = sc.nextLine();

			try (BufferedReader br = new BufferedReader(new FileReader(DEFAULT_PROPERTIES_PATH))) {
				Properties properties = new Properties();

				// loading
				properties.load(br);
				
				String pwd = properties.getProperty(inputUserId + ".pwd");

				if (pwd != null && pwd.equals(inputUserPwd)) {
					System.out.println("로그인 성공하였습니다.");
					isLoggedIn = true;
				} else {
					System.out.println("로그인에 실패했습니다. 아이디 또는 비밀번호가 일치하지 않습니다.");
				}
			} catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} while(!isLoggedIn);
	}

}