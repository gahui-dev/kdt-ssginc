package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jsp.dto.CustomerDTO;
import com.jsp.util.DataBaseUtil;

public class CustomerDAO {
	private static final CustomerDAO _instance = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return _instance;
	}
	
	// 로그인
	public ArrayList<CustomerDTO> selectCustomer(CustomerDTO dto) {
		ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>();
		String dql = "SELECT * FROM Customer WHERE userid = ? AND password = sha2(?, 256);";
		
		try(Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dql);
				) {
				pstmt.setString(1, dto.getUserid());
				pstmt.setString(2, dto.getPassword());
			
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {                
	                CustomerDTO CustomerDto = new CustomerDTO();
	                CustomerDto.setCustid(rs.getInt("custid"));
	                CustomerDto.setUserid(rs.getString("userid"));
	                CustomerDto.setPassword(rs.getString("password"));
	                CustomerDto.setName(rs.getString("name"));
	                CustomerDto.setAddress(rs.getString("address"));
	                CustomerDto.setPhone(rs.getString("phone"));
	                list.add(CustomerDto);
	            }
				
			} catch (SQLException e) {
				System.out.println("데이터베이스 예외 발생 ");
				e.printStackTrace();
			}
			
			return list;	
	}
	
	
//	public Boolean selectCustomer(CustomerDTO dto) {
//		Boolean status = false;
//		String dql = "SELECT * FROM Customer WHERE userid = ? AND password = sha2(?, 256);";
//		
//		try(Connection conn = DataBaseUtil.getConnection();
//			PreparedStatement psmt = conn.prepareStatement(dql)) {
//			
//			psmt.setString(1, dto.getUserid());
//			psmt.setString(2, dto.getPassword());
//			
//            ResultSet rs = psmt.executeQuery();
//            System.out.println(rs);
//            
//            
//            status = rs.next();
//            System.out.println("test >> " + status);
//			
//		} catch(SQLException e) {
//			System.out.println("데이터베이스 예외 발생 ");
//			e.printStackTrace();
//		}
//				
//		return status;
//	}
//	
	
	// 회원가입 
	public int insertCustomer(CustomerDTO dto) {
		int status = 0;
		String dql = "INSERT INTO Customer (userid, password, name, address, phone) VALUES (?, SHA2(?, 256), ?, ?, ?);";

		try (Connection conn = DataBaseUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(dql)) {

			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getPhone());

			status = pstmt.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 예외 발생 ");
		}

		return status;
	}
}
