package com.java.class15.fileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class DatabaseManager {
	private static final String DATABASE_PATH 
	= Paths.get(File.separator + "Users", "GAHUI", "Documents", "test", "database", "application.ini").toString();

	// 로그인
	public static Boolean loginUser(Scanner sc) {
		try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_PATH));) {
			Properties properties = new Properties();

			// loading
			properties.load(br);

			System.out.print("아이디를 입력해주세요 >> ");
			String inputUserId = sc.nextLine();
			System.out.print("패스워드를 입력해주세요 >> ");
			String inputUserPwd = sc.nextLine();

			String totalUser = properties.getProperty("total.user");
			int numOfUser = totalUser != null ? Integer.parseInt(totalUser) : 0;

			for (int i = 1; i <= numOfUser; i++) {
				String id = properties.getProperty("id" + i);
				String pwd = properties.getProperty(id + ".pwd");

				if ((id != null && inputUserId.equals(id))
						&& (pwd != null && inputUserPwd.equals(pwd))) {
					System.out.println("로그인 성공");
					return true;
				}
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 회원가입
	public static void registerUser(Scanner sc) {
		try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_PATH ))) {
			Properties properties = new Properties();

			// loading
			properties.load(br);

			boolean isCheck = false;

			while (true) {
				System.out.print("아이디를 입력해주세요 >> ");
				String inputUserId = sc.nextLine();

				String totalUser = properties.getProperty("total.user");
				int numOfUser = totalUser != null ? Integer.parseInt(totalUser) : 0;

				// 아이디 중복 검사
				for (int i = 1; i <= numOfUser; i++) {
					String id = properties.getProperty("id" + i);

					if (id != null && inputUserId.equals(id)) {
						isCheck = true;
						System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
						break;
					}
				}

				if (!isCheck) {
					System.out.print("패스워드를 입력해주세요 >> ");
					String inputUserPwd = sc.nextLine();

					BufferedWriter bw = new BufferedWriter(new FileWriter(DATABASE_PATH));
					int totalUsers = Integer.parseInt(properties.getProperty("total.user", "0")) + 1;

					properties.setProperty("total.user", String.valueOf(totalUsers));
					String newUserIdKey = "id" + totalUsers;

					properties.setProperty(newUserIdKey, inputUserId);
					properties.setProperty(inputUserId + ".pwd", inputUserPwd);
					properties.store(bw, "Add new member");
					bw.flush();

					System.out.println("회원가입이 완료되었습니다.");
					break;
				}

				isCheck = false;
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
