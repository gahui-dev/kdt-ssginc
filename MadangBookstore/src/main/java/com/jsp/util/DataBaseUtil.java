package com.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtil {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/madang?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USERNAME = "madang";
	private static final String PASSWORD = "A55870415b^";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 Driver를 찾지 못했습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결에 실패했습니다. ");
			e.printStackTrace();
		}

		return conn;
	}
}
