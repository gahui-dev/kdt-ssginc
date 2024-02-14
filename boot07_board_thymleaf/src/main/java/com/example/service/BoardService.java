package com.example.service;

import com.example.dto.BoardDTO;
import com.example.dto.PageDTO;

public interface BoardService {
	public PageDTO findAll(int curPage);
	public int write(BoardDTO dto);
	public BoardDTO retrieve(int x);
	public int update(BoardDTO dto);
	public int delete(int num);
	
}