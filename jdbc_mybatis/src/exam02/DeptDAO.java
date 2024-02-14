package exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// dept 테이블  접근용
public class DeptDAO {

	public List<DeptDTO> findAll(Connection con) {
		
		// DeptDTO 누적용
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select deptno, dname as name, loc from dept";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("name");
				String loc = rs.getString(3);
				//하나의 레코드를 DTO에 저장
				DeptDTO dto = new DeptDTO(deptno, dname, loc);
				//누적
				list.add(dto);
			}
		}catch(Exception e) {
		}finally {
		   try {	
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		   }catch(Exception e) {
			   
		   }
		}
		return list;
	}//end findAll

	public int save(Connection con, DeptDTO dto)
			throws DuplicatedDeptnoException {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into dept ( deptno, dname, loc ) values (?,?,? )";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
		
			num = pstmt.executeUpdate();
			
		}catch(Exception e) {
			//중복인 경우 catch됨.
			// 명시적으로 DuplicatedDeptnoException 발생시킴.
			throw new DuplicatedDeptnoException(dto.getDeptno()+" 중복되어 예외 발생~");
			
		}finally {
		   try {	
			if(pstmt!=null)pstmt.close();
		   }catch(Exception e) {
			   
		   }
		}
		return num;
	}

	public int update(Connection con, DeptDTO dto) {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "update dept set dname=?, loc=? where deptno=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(3, dto.getDeptno());
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
		
			num = pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
		   try {	
			if(pstmt!=null)pstmt.close();
		   }catch(Exception e) {
			   
		   }
		}
		return num;
	}

	public int remove(Connection con, int deptno) {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from dept where deptno=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
		
			num = pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
		   try {	
			if(pstmt!=null)pstmt.close();
		   }catch(Exception e) {
			   
		   }
		}
		return num;
	}
}//end class
