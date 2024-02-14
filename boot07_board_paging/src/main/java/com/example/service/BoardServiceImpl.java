package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.dto.BoardDTO;
import com.example.dto.PageDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;

	// 생성자 주입으로 객체 생성
//	public public BoardServiceImpl(BoardDAO dao) {
//		this.dao = dao;
//	}

	@Override
	public PageDTO findAll(int curPage) {
		return dao.findAll(curPage);
	}


	@Override
	public int write(BoardDTO dto) {
		return dao.write(dto);
	}

	@Override
	public BoardDTO retrieve(int x) {
		
		// 조회수 증가 메서드 호출
		int n = dao.readcnt(x);
		
		return dao.retrieve(x);
	}

	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int num) {
		return dao.delete(num);
	}

	



}