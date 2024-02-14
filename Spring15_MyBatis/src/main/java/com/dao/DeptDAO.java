package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.DeptDTO;

@Repository
public class DeptDAO {
	@Autowired
	// xml에서 설정한 SqlSessionTemplate을 주입받아 사용 
	SqlSessionTemplate session; // MyBatis의 SqlSession 역
	
	public List<DeptDTO> findAll() {
		return session.selectList("com.config.DeptMapper.findAll");	
	}
	
	public int save(DeptDTO dto) throws Exception{
		return session.insert("com.config.DeptMapper.save", dto);
	}
	
	public int update(DeptDTO dto) {
		return session.update("com.config.DeptMapper.update", dto);
	}
	
	public int remove(int deptno) {
		return session.delete("com.config.DeptMapper.remove", deptno);
	}
}
