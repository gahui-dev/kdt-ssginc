package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.MovieDTO;
import com.jsp.entity.MovieEntity;
import com.jsp.util.DataBaseUtil;
import com.jsp.util.PageMaker;

public class MovieDAO {
	private static final MovieDAO _instance = new MovieDAO();
	public static MovieDAO getInstance() {
		return _instance;
	}

	public ArrayList<MovieDTO> selectMovieInfo() {
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String dql = "SELECT * FROM movie_list";

		try (Connection conn = DataBaseUtil.getConnection();
			PreparedStatement psmt = conn.prepareStatement(dql);) {
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				MovieDTO MovieDto = new MovieDTO();
				MovieDto.setM_id(rs.getInt("m_id"));
				MovieDto.setM_name(rs.getString("m_name"));
				list.add(MovieDto);
			}
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
			e.printStackTrace();
		}
		return list;
	}
	
	public void selectMovieInfo(ArrayList<MovieDTO> list) {
		//ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		String dql = "SELECT * FROM movie_list";

		try (Connection conn = DataBaseUtil.getConnection();
			PreparedStatement psmt = conn.prepareStatement(dql);) {
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				MovieDTO MovieDto = new MovieDTO();
				MovieDto.setM_id(rs.getInt("m_id"));
				MovieDto.setM_name(rs.getString("m_name"));
				list.add(MovieDto);
			}
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
			e.printStackTrace();
		}
		//return list;
	}
	
	public List<MovieEntity> selectMovieByPaging(PageMaker pageMaker) {
		String dql = "SELECT (SELECT COUNT(*) FROM movie_list) AS totalDataCount, A.* \n"
				+ "  FROM (SELECT * FROM movie_list ORDER BY m_id DESC LIMIT ?, ?) A;";
		// System.out.println(dql);
		ArrayList<MovieEntity> movieList = new ArrayList<MovieEntity>();
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dql);) {
			
			int startNum = pageMaker.getCriteriaPageNum() * pageMaker.getCriteriaAmount() - (pageMaker.getCriteriaAmount() - 1); 
			int endNum = pageMaker.getCriteriaAmount();
			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);	
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieEntity entity = new MovieEntity();
				entity.setTotalDataCount(rs.getInt("totalDataCount"));
				entity.setM_id(rs.getInt("m_id"));
				entity.setM_name(rs.getString("m_name"));
				movieList.add(entity);
			}
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
			e.printStackTrace();
		}
		
		return movieList;
	}
	
	private Connection getConnection() throws SQLException {
		return DataBaseUtil.getConnection();
		//return DBCP2Util.getConnection();
	}
}
