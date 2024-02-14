package exam07;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DeptMybatisDAO {

	public List<DeptDTO> findAll(SqlSession session){
		return session.selectList("exam07.DeptMapper.findAll");
	}
	public int save(SqlSession session, DeptDTO dto) {
		return session.insert("exam07.DeptMapper.save", dto);
	}
	
	public int update(SqlSession session, DeptDTO dto) {
		return session.update("exam07.DeptMapper.update", dto);
	}
	
	public int remove(SqlSession session, int deptno) {
		return session.update("exam07.DeptMapper.remove", deptno);
	}
	
}
