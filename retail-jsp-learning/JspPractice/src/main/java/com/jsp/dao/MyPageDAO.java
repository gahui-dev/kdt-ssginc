package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.dto.PersonDTO;
import com.jsp.util.DBCP2Util;

public class MyPageDAO {
	private static final MyPageDAO _instance = new MyPageDAO();

	public static MyPageDAO getInstance() {
		return _instance;
	}

	private static final String SELECT_DQL = "SELECT * FROM Person WHERE userid = ?";
	private static final String UPDATE_DQL = "UPDATE Person SET name = ?, password = SHA2(?, 256), phone = ?  WHERE userid = ?;";

	// MyPage 정보 가져오기
	public PersonDTO selectPersonInfo(String userid) {
		//ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		PersonDTO personDto = null;
		
		try (Connection conn = DBCP2Util.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(SELECT_DQL);) {

			pstmt.setString(1, userid);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				personDto = new PersonDTO();
				personDto.setSeq(rs.getInt("seq"));
				personDto.setUserid(rs.getString("userid"));
				personDto.setPassword(rs.getString("password"));
				personDto.setName(rs.getString("name"));
				personDto.setLevel(rs.getInt("level"));
				personDto.setGender(rs.getString("gender"));
				personDto.setPhone(rs.getString("phone"));
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

	// MyPage 정보 수정하기
	public int updatePersonInfo(PersonDTO dto) {
		int status = 0;

		try (Connection conn = DBCP2Util.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(UPDATE_DQL);) {
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getUserid());
			
			status = pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}

		return status;
	}
}
