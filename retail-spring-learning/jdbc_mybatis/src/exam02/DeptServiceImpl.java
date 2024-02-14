package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DeptServiceImpl implements DeptService {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF8";
	String userid = "root";
	String passwd = "root1234";

	// 생성자
	public DeptServiceImpl() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// end 생성자

	// select 기능구현 메서드
	@Override
	public List<DeptDTO> findAll() {

		List<DeptDTO> list = null;
		// Connection 만 얻고 close 까지.
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			list = dao.findAll(con);
		} catch (Exception e) {

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return list;
	}// end findAll

	@Override
	public int save(DeptDTO dto)
	 throws DuplicatedDeptnoException{
		int num = 0;
		// Connection 만 얻고 close 까지.
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			num = dao.save(con, dto);
		} catch (SQLException e) {
			// DuplicatedDeptnoException 제외한 나머지 SQL관련 예외를 catch
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}

		return num;
	}// end save

	@Override
	public int update(DeptDTO dto) {
		int num = 0;
		// Connection 만 얻고 close 까지.
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			num = dao.update(con, dto);
		} catch (SQLException e) {
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return num;
	}

	@Override
	public int remove(int deptno) {
		int num = 0;
		// Connection 만 얻고 close 까지.
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			num = dao.remove(con, deptno);
			
		} catch (SQLException e) {
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return num;
	}

	@Override
	public int updateAndRemove(DeptDTO dto, int deptno) {
		int num = 0;
		// Connection 만 얻고 close 까지.
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DAO 연동
			DeptDAO dao = new DeptDAO();
			/////////////////////////////////
			// 트랜잭션으로 처리시작
con.setAutoCommit(false);
			// 수정할 작업
			int a = dao.update(con, dto);
			
			//삭제할 작업
			int b = dao.remove(con, deptno);
			num = a + b;
con.commit(); // update와 remove 모두 성공한 경우			
			////////////////////////////////////
		} catch (SQLException e) {
			
try {
	if (con != null) con.rollback();
} catch (SQLException e1) {
	e1.printStackTrace();
}

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		return num;
	}

	
	/*
	    트랜잭션(transaction)
	 1. DML 만 적용됨. (insert, delete, update )
	 2. 개념:
	        여러 DML 작업을 하나의 작업처럼 논리적으로 묶어서 처리할 수 있는 개념이다.
	   만약 세부적인 작업들이 모두 성공했을 경우에는 실제 DB에 반영시키고
	   만약에 하나라도 실패하면 모두 이전에 했던 DML 작업을 취소 시킬수 있는 개념이다.
	
	 3. JDBC 구현
	 
	   Connection con = DriverManager.getConnection(url, usrid, passwd);
	  try{
con.setAutoCommit(false); // auto commit 비활성화 ==> 명시적으로  commit 또는 rollback 가능
       DML문장1;
       DML문장2;
       DML문장3;
con.commit();
     }catch(Exception e){
con.rollback();
     }
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
}// end class
