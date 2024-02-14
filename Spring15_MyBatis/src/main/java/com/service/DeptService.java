package com.service;

import java.util.List;

import com.dto.DeptDTO;
import com.exception.DuplicatedDeptnoException;

public interface DeptService {
	
	public List<DeptDTO> findAll();
	public int save(DeptDTO dto) throws DuplicatedDeptnoException;
	public int update(DeptDTO dto);
	public int delete(int deptno);
}
