package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dto.MovieDTO;
import com.jsp.util.DBCP2Util;

public class MovieDAO {
	private static final MovieDAO _instance = new MovieDAO();

	public static MovieDAO getInstance() {
		return _instance;
	}
	
	String DQL = "SELECT * FROM movie_list";

	public ArrayList<MovieDTO> selectMovieInfo() {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		
		try (Connection conn = DBCP2Util.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(DQL);) {
			 ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieDTO MovieDto = new MovieDTO();
				MovieDto.setM_id(rs.getInt("m_id"));
				MovieDto.setM_name(rs.getString("m_name"));
				list.add(MovieDto);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
			e.printStackTrace();
		}
		return list;
	}
}
