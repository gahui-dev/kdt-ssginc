package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.dto.CustomerEntity;
import com.jsp.dto.LoginDTO;
import com.jsp.util.DBCP2Util;
import com.jsp.util.DataBaseUtil;

public class LoginDAO {
	private static final LoginDAO _instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return _instance;
	}

	public static boolean equal(int target, int source) {
		return target == source;
	}

	private String getResolveQuery(String FORMAT_QUERY, String query1, String query2, String query3) {
		String dql = "";
		dql = String.format(FORMAT_QUERY, query1, query2, query3);
		return dql;
	}
	
	public int selectUserAndPwd_stmt(LoginDTO dto) {

		String dql = "SELECT count(*) as login \r\n" + "FROM %s\r\n" + "WHERE username = '%s'\r\n"
				+ "AND password = SHA2('%s',256);\r\n";
		dql = getResolveQuery(dql, "member", dto.getUsername(), dto.getPassword());

		System.out.println("username: " + dto.getUsername());
		System.out.println("pasword : " + dto.getPassword());
		System.out.println("<DB SQL문>\n" + dql);

		int count = 0;
		try (Connection conn = DataBaseUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(dql);) {
			if (rs.next()) {
				count = rs.getInt("login");
			}
			System.out.println("[LoginDAO] 인증쿼리 성공(1), 실패(0) : " + count);
		} catch (SQLException e) {
			System.out.println("[LoginDAO] 데이터베이스 예외발생");
			e.printStackTrace();
		}

		return count;
	}

	public int selectUserAndPwd(LoginDTO dto) {

		String dql = "SELECT count(*) as login\r\n" + " FROM %s \r\n" + " WHERE username = ?\r\n"
				+ " AND password = sha2(?, 256);\r\n";
		dql = getResolveQuery(dql, "member", null, null);
		System.out.println(dql);

		int count = 0;

		try ( // Connection conn = DataBaseUtil.getConnection();
				Connection conn = DBCP2Util.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dql);) {

			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("login");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}

		return count;
	}

	

	public CustomerEntity selectUserByUserNameAndPwd(LoginDTO dto) {
		String dql = " SELECT name FROM %s\r\n" + " WHERE custid=\r\n" + " (SELECT custid FROM member \r\n"
				+ " WHERE username=?\r\n" + " AND password=SHA2(?,256))\r\n";
		dql = getResolveQuery(dql, "customer", null, null);
		System.out.println(dql);

		CustomerEntity entity = null;
		try (
//				Connection conn = DBCP2Util.getConnection();
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dql);) {
			System.out.println("데이터베이스 연결성공");

			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = new CustomerEntity();
				entity.setName(rs.getString(1));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}

		return entity;

	}

	public static void main(String[] args) {
		LoginDTO dto = new LoginDTO();
		dto.setUsername("root");
		dto.setPassword("root1234");

		LoginDAO dao = LoginDAO.getInstance();
//		System.out.println(equal(dao.selectUserAndPwd(dto), 1));

		dao.selectUserByUserNameAndPwd(dto);
		// if(dao.selectUserAndpwd(dto)==1) { }

	}

}
