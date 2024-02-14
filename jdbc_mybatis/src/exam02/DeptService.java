package exam02;

import java.util.List;

public interface DeptService {
	public List<DeptDTO> findAll();
	
	public int save(DeptDTO dto)throws DuplicatedDeptnoException;
	public int update(DeptDTO dto);
	public int remove(int deptno);
	
	public int updateAndRemove(DeptDTO dto, int deptno);
}
