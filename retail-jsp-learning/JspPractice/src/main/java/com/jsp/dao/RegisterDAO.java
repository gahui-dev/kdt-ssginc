package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jsp.dto.PersonDTO;
import com.jsp.util.DataBaseUtil;

public class RegisterDAO {
	private static final RegisterDAO _instance = new RegisterDAO();

	public static RegisterDAO getInstance() {
		return _instance;
	}

	private static final String DQL = "INSERT INTO Person (userid, password, name, level, gender, phone) VALUES (?, SHA2(?, 256), ?, ?, ?, ?);";

	public int insertPerson(PersonDTO dto) {
		int status = 0;

		try (Connection conn = DataBaseUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(DQL)) {

			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getLevel());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getPhone());

			status = pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
		}

		return status;
	}
}
