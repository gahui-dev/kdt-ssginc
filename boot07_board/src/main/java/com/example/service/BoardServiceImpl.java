package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	BoardDAO dao;
	
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BoardDTO> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public int write(BoardDTO dto) {
		return dao.write(dto);
	}

	@Override
	public BoardDTO retrieve(int x) {
		// 조회 수 증가 메서드 호출
		int n = dao.readcnt(x);
		
		return dao.retrieve(x);
	}

	@Transactional
	@Override
	public int update(BoardDTO dto) {		
		return dao.update(dto);
	}

	@Override
	public int delete(int num) {
		return dao.delete(num);
	}	
}
