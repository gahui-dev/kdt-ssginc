package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {

	public static void main(String[] args) {
		
		// testdb의 dept 연동
		
		/*
	        1. 환경설정
	           - DB 설치: MySQL
	           - 설치된 DB 회사에서 제공한 라이브러리 필요 (드라이버라고 부른다,  *.jar )
	           - STS에서 *.jar 인식 ====> 빌드패스(build path)
	        2. mysql(oracle) 연동시 4가지 정보 필요
	           ==> oracle port: 1521
	         
	          - 드라이버명: com.mysql.cj.jdbc.Driver
	          - url:    jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF8
	          - userid: root
	          - passwd: root1234
	          
	        3. 드라이버 로딩 ==> "com.mysql.cj.jdbc.Driver" 메모리에 올리는 작업
	           Class.forName("com.mysql.cj.jdbc.Driver");
	           
	        4. Connection 맺기 ( DB 연결 )
	         Connection con = DriverManager.getConnection(url, userid, passwd);

 			5. sql 문 작성
 			   String sql = "select deptno, dname, loc from dept";
 			   
 			6. PreparedStatement 생성 ( sql 문 전송 )
 			  
 			   PreparedStatement pstmt = con.prepareStatement(sql); // 아직 sql문 전송 안됨
 			 
 			7. sql 문 전송
 			  
 			     가. select 문
 			     ResultSet rs = pstmt.executeQuery();
 			     // ResultSet 은 select문이 실행된 결과인 테이블을 객체화한 것이다.
 			       
 			     나. insert/delete/update 문 (DML)
 			     
 			     int n = pstmt.executeUpdate();
 			     
 			8. 자원 반납 ( 사용했던 순서의 역순, 무조건 적용 )
 			    rs.close();
 			    pstmt.close();
 			    con.close();
		 */
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF8";
			String userid="root";
			String passwd="root1234";
		
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(url, userid, passwd);
				String sql = "select deptno, dname as name, loc from dept";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("name");
					String loc = rs.getString(3);
					System.out.println(deptno+"\t"+dname+"\t"+loc);
				}
			}catch(Exception e) {
			}finally {
			   try {	
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			   }catch(Exception e) {
				   
			   }
			}
	}//end main

}//end class
