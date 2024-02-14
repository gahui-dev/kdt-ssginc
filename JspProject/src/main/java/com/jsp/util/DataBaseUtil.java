package com.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
	   /*
	    * Database 호환성
	    * 1. MySQL : 8.0.34 Community Server
	    * 2. Conector : mysql-connector-j 8.1.0 jbdc4 driver implemented
	    * 
	    * 사용법
	    * 1. Driver를 로딩(메모리로 로딩)
	    * 2. Driver Name : com.mysql.cj.jdbc.Driver
	    * 3. Url : localhost:3306/madang
	    * 4. Username : madang
	    * 5. Password :
	    * 6. Connection 
	    *    -> Statement (Sql) / PrepareStatement
	    *    -> ResultSet 
	    *    -> Cursor(Selection 단위)
	    *      -> next() (맨 처음 header, 맨 마지막 EOF (false)
	    *      -> projection 단위로 접근
	    * */
	   
	   public static void main(String[] args) {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         String url = "jdbc:mysql://localhost:3306/madang";
	         String username = "madang";
	         String password = "A55870415b^";
	         
	         try(Connection conn = DriverManager.getConnection(url, username, password);
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM book");
	            ) {
	                  
	             while(rs.next()) {
	                System.out.print(rs.getInt("bookid"));
	                System.out.print("\t" + rs.getString("bookname"));
	                System.out.print("\t" + rs.getString("publisher"));
	                System.out.println("\t" + rs.getInt("price"));
	             }
	             
	         } catch (SQLException e) {
	            System.out.println("데이터베이스 예외 발생");
	            e.printStackTrace();
	         } 
	      } catch (ClassNotFoundException e) {
	         System.out.println("데이터베이스 Driver를 찾지 못했습닌다. ");
	         e.printStackTrace();
	      }
	   }
	   
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