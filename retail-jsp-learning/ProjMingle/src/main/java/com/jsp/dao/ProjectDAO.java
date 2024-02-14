package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dto.ProjectDTO;
import com.jsp.util.DataBaseUtil;

public class ProjectDAO {
	private static final ProjectDAO _instance = new ProjectDAO();
	
	public static ProjectDAO getInstance() {
		return _instance;
	}

	private static final String selectDQL
	= "SELECT p.PROJ_SEQ, p.TITLE, p.SDATE, p.EDATE, P.PURPOSE\n"
			+ "	  FROM T_USER AS u\n"
			+ "	  INNER JOIN T_PROJECT_MATCH AS m\n"
			+ "	     ON u.USER_SEQ = m.USER_SEQ\n"
			+ "	  INNER JOIN T_PROJECT AS p\n"
			+ "	     on m.PROJ_SEQ = p.PROJ_SEQ\n"
			+ "	  WHERE u.NAME = ?";
	private static final String DQL
		= "INSERT INTO T_PROJECT (TITLE, PURPOSE, SDATE, EDATE, CONTENT) VALUES (?, ?, DATE_FORMAT(?, '%Y-%m-%d'), DATE_FORMAT(?, '%Y-%m-%d'), ?);";
	
	
	
	public ArrayList<ProjectDTO> selectProject(String name) {
		ArrayList<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
		
		try ( Connection conn = DataBaseUtil.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(selectDQL);) {

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {                
				ProjectDTO projectDto = new ProjectDTO();
				projectDto.setProject(rs.getInt("PROJ_SEQ"));
				projectDto.setTitle(rs.getString("TITLE"));
				projectDto.setsDate(rs.getString("SDATE").substring(0, 10));
				projectDto.seteDate(rs.getString("EDATE").substring(0, 10));
				projectDto.setPurpose(rs.getString("PURPOSE"));
				projectList.add(projectDto);
            }
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}
		return projectList;
	}
	
	public int createProject(ProjectDTO dto) {
		int result = 0;
		
		try ( Connection conn = DataBaseUtil.getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(DQL);) {
				
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getPurpose());
			pstmt.setString(3, dto.getsDate());
			pstmt.setString(4, dto.geteDate());
			pstmt.setString(5, dto.getContent());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외발생");
			e.printStackTrace();
		}
		
		return result;
	}
}
