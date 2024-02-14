package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;

import com.jsp.dto.MemberDTO;
import com.jsp.util.DataBaseUtil;

public class MemberDAO {
	private static final MemberDAO _instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return _instance;
	}
	
	public List<Map<String, Object>> selectUser() {

		List<Map<String, Object>> userList = new ArrayList<>();
		
		String dql = "SELECT * FROM member;";
		ResultSet rs = null;
		
		try(Connection conn = DataBaseUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(dql)) {
			
			System.out.println("데이터베이스 연결 성공 ");
			
			rs = preparedStatement.executeQuery();
			
			 while(rs.next()) {
				Map<String, Object> resMap = new HashMap<>();
				
//				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				for (int i = 1; i <= 2; i++) {
	                resMap.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
	            }
				userList.add(resMap);
             }
		
	        conn.close();		
		} catch(SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
	//		e.printStackTrace();
		}
	
		return userList;
	}
	
	public int insertUser(MemberDTO dto) {
		int status = 0;
		String dql = "INSERT INTO MEMBER (username, password) VALUES (?, SHA2(?, 256));";
		
//		System.out.println(dql);
//      System.out.println(dto.getUsername());
//      System.out.println(dto.getPassword());
		
		try(Connection conn = DataBaseUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(dql)) {
			
			preparedStatement.setString(1, dto.getUsername());
	        preparedStatement.setString(2, dto.getPassword());
			
	//		System.out.println("데이터베이스 연결 성공 ");
	//		System.out.println(preparedStatement);
	        
	        status = preparedStatement.executeUpdate();
	        
	        conn.close();		
		} catch(SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
//			e.printStackTrace();
		}
		
		return status;
	}
}
