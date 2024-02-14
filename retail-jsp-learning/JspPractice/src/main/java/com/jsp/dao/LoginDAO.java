package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.dto.PersonDTO;
import com.jsp.util.DBCP2Util;

public class LoginDAO {
	private static final LoginDAO _instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return _instance;
	}
	
	private static final String DQL = "SELECT userid, level, name FROM Person WHERE userid = ? AND password = SHA2(?, 256) AND level = ?;";	
	
	public PersonDTO selectPersonInfo(PersonDTO dto) {
		PersonDTO personDto = null;
		
		try ( Connection conn = DBCP2Util.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(DQL);) {

			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setInt(3, dto.getLevel());

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {                
				personDto = new PersonDTO();
                personDto.setUserid(rs.getString("userid"));
                personDto.setLevel(rs.getInt("level"));
                personDto.setName(rs.getString("name"));
            }
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}
		
		return personDto;
	}
}
