package com.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtil {
	public static Connection getConnection() {      
	      Connection conn = null;
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         String url = "jdbc:mysql://localhost:3306/madang?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
	         String username = "madang";
	         String password = "A55870415b^";
	         conn = DriverManager.getConnection(url, username, password);
	      } catch (ClassNotFoundException e) {
	         System.out.println("데이터베이스 Driver를 찾지 못했습니다. ");
	         e.printStackTrace();
	      } catch(Exception e) {
	         System.out.println("데이터베이스 연결 실패");
	         e.printStackTrace();
	      }
	      
	      return conn;
	   }	   
}
