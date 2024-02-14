package com.example.service;

import java.util.List;

import com.example.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> findAll();
	public int write(BoardDTO dto);
	public BoardDTO retrieve(int x);
	public int update(BoardDTO dto);
	public int delete(int num);
}
