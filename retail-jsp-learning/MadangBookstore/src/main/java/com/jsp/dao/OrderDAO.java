package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dto.OrderDTO;
import com.jsp.util.DataBaseUtil;

public class OrderDAO {
	private static final OrderDAO _instance = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return _instance;
	}
	
	public ArrayList<OrderDTO> selectOrderInfo(int custid) {
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		String dql = "SELECT O.orderdate AS orderdate, B.bookname AS bookname, B.publisher AS publisher, B.price AS price FROM Orders AS O INNER JOIN Book AS B ON O.bookid = B.bookid WHERE custid = ?;";
		
		
		try(Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(dql);
			) {
			pstmt.setInt(1, custid);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {                
	            OrderDTO orderDto = new OrderDTO();
//	            orderDto.setOrderid(rs.getInt("orderid"));
//	            orderDto.setCustid(rs.getInt("custid"));
//	            orderDto.setBookid(rs.getInt("bookid"));
//	            orderDto.setSaleprice(rs.getInt("saleprice"));
//	            orderDto.setOrderdate(rs.getString("orderdate"));
	            orderDto.setOrderdate(rs.getString("orderdate"));
	            orderDto.setBookname(rs.getString("bookname"));
	            orderDto.setPublisher(rs.getString("publisher"));
	            orderDto.setPrice(rs.getInt("price"));
	            list.add(orderDto);
	        }
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insertOrder(OrderDTO dto) {
		int status = 0;
		String dql = "INSERT INTO Orders (custid, bookid, saleprice, orderdate) VALUES (?, ?, ?, date_format(date(sysdate()),'%Y-%m-%d'));";
		
		try (Connection conn = DataBaseUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(dql)) {

			pstmt.setInt(1, dto.getCustid());
			pstmt.setInt(2, dto.getBookid());
			pstmt.setInt(3, dto.getSaleprice());

			status = pstmt.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
		}

		return status;
		
	}
}
