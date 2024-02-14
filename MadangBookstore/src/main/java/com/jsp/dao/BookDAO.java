package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dto.BookDTO;
import com.jsp.util.DataBaseUtil;

public class BookDAO {
	private static final BookDAO _instance = new BookDAO();
	
	public static BookDAO getInstance() {
		return _instance;
	}
	
	public ArrayList<BookDTO> selectBookInfo() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		String dql = "SELECT * FROM book;";
		
		try(Connection conn = DataBaseUtil.getConnection();
			PreparedStatement psmt = conn.prepareStatement(dql);
			) {
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {                
                BookDTO bookDto = new BookDTO();
                bookDto.setBookid(rs.getInt("bookid"));
                bookDto.setBookname(rs.getString("bookname"));
                bookDto.setPublisher(rs.getString("publisher"));
                bookDto.setPrice(rs.getInt("price"));
                list.add(bookDto);
            }
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
			e.printStackTrace();
		}
		
		return list;
	}
}
