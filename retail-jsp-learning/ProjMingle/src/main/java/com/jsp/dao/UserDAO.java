package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.dto.UserDTO;
import com.jsp.util.DataBaseUtil;

public class UserDAO {
	private static final UserDAO _instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return _instance;
	}
	
	private static final String SignUpDQL = "INSERT INTO T_USER (MAIL, PASSWORD, NAME) VALUES (?, SHA2(?, 256), ?);";
	private static final String SignInDQL = "SELECT MAIL, NAME FROM T_USER WHERE MAIL = ? AND PASSWORD = SHA2(?, 256);";
	
	public int signUp(UserDTO dto) {
		int result = 0;
		
		try ( Connection conn = DataBaseUtil.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(SignUpDQL);) {
			
			pstmt.setString(1, dto.getMail());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}
		return result;
	}

	public UserDTO signIn(UserDTO dto) {
		UserDTO userDto = null;
		
		try ( Connection conn = DataBaseUtil.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(SignInDQL);) {

			pstmt.setString(1, dto.getMail());
			pstmt.setString(2, dto.getPassword());

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {                
				userDto = new UserDTO();
				userDto.setMail(rs.getString("MAIL"));
				userDto.setName(rs.getString("NAME"));
            }			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}
		return userDto;
	}
	
}
