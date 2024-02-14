package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.DeptDAO;
import com.example.dto.DeptDTO;
import com.example.exception.DuplicatedDeptnoException;

@Service("service")
public class DeptServiceImpl implements DeptService {

   @Autowired
   DeptDAO dao;

   @Override
   public List<DeptDTO> findAll() {
      return dao.findAll();
   }

   @Transactional
   @Override
   public int save(DeptDTO dto) throws DuplicatedDeptnoException {
      int n = 0;
      try {
         n = dao.save(dto);

      } catch (Exception e) {
         e.printStackTrace();
         System.out.println(e.getMessage());
         throw new DuplicatedDeptnoException(dto.getDeptno() + "중복되어 예외 발생");
      }
      return n;
   }

   @Transactional
   @Override
   public int update(DeptDTO dto) {
      // TODO Auto-generated method stub
      return dao.update(dto);
   }

   @Transactional
   @Override
   public int remove(int deptno) {
      // TODO Auto-generated method stub
      return dao.remove(deptno);
   }

}