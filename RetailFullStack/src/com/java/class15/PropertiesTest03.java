package com.java.class15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;


public class PropertiesTest03 {

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
			try(BufferedReader br = new BufferedReader(new FileReader(DEFAULT_PROPERTIES_PATH));
					//BufferedWriter bw = new BufferedWriter(new FileWriter(DEFAULT_PROPERTIES_PATH));
					){
				Properties properties = new Properties();

				// loading
				properties.load(br);

				String id = properties.getProperty("id");
				String pwd = properties.getProperty(id + ".pwd");

				String totalUser = properties.getProperty("total.user");
				System.out.println(totalUser);
				
				// 조건식 ? (참) : (거짓)
				int numOfUser = totalUser != null ? Integer.parseInt(totalUser) : 0;
				System.out.println("users 수 : " + numOfUser);

				for(int i = 0; i < numOfUser; i++ ) {
					id = properties.getProperty("id" + i);
					pwd = properties.getProperty(id + ".pwd");
					
					
					if((id != null && inputUserId.equals(id))
							&& (pwd != null && inputUserPwd.equals(pwd))) {
						System.out.println("로그인 성공");
						isLoggedIn = true;
						//break;
					} 
				}

				if(!isLoggedIn) {
					System.out.println("로그인 실패");
				}

				
				System.out.println("수행할 작업을 입력하세요.");
				
				// 회원가입시 setProperties를 쓰려면
				//			properties.setProperty("total.user", "5");
				//			bw = new BufferedWrite(new FileWriter(DEFAULT_PROPERTIES_PATH));
				//			properties.store(bw, "comment");
				//			bw.flush();
			} catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 항상 실행
				//			if(bw != null) {
				//				try {
				//					bw.close();
				//				} catch(IOException e) {
				//
				//				}bw = null;
				//			}
			}

		} while(!isLoggedIn);
	}

}
