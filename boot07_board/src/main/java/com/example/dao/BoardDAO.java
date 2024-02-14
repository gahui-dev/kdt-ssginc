package com.example.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate session;

//  페이징 처리 전 
//	public List<BoardDTO> findAll() {
//		return session.selectList("com.config.BoardMapper.findAll");
//	}
	
	public List<BoardDTO> findAll() {
		return session.selectList("com.config.BoardMapper.findAll");
	}

	public int write(BoardDTO dto) {
		return session.insert("com.config.BoardMapper.write", dto);
	}

	public BoardDTO retrieve(int x) {
		HashMap<String, Object> map = session.selectOne("com.config.BoardMapper.retrieve", x);

		// DTO 생성방법
		/*
		 * 1. 생성자 이용 여러 오버로딩 생성자가 필요 값만 넣기 때문에 의미전달이 어렵다.
		 * 필수항목에 대한 인지가 어렵다.
		 */
		// HashMap을 DTO로 변환
		int num = (int) map.get("num");
		String title = (String) map.get("title");
		String author = (String) map.get("author");
		String content = (String) map.get("content");

		// Date를 String으로 변환 과정
		Date yyy = (Date) map.get("writeday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String writeday = sdf.format(yyy);

		int readcnt = (int) map.get("readcnt");

		BoardDTO dto1 = new BoardDTO(num, title, author, content, writeday, readcnt);

		// 2. set 메서드
		/*
		 * 생성자보다 인자의 의미파악이 쉬워졌음
		 * 1회 호출해서는 생성 완료가 안됨
		 * 필수항목에 대한 인지가 어려움 
		 * */
		BoardDTO dto2 = new BoardDTO();
		dto2.setNum(num);
		dto2.setTitle(title);
		dto2.setAuthor(author);
		dto2.setContent(content);
		dto2.setWriteday(writeday);
		dto2.setReadcnt(readcnt);
		
		
		// 3. 빌더 패턴
		/*
		 * 인자의 의미파악이 확실 
		 * 1번 호출해서 객체 
		 * */
		BoardDTO dto = BoardDTO.builder()
							.num(num)
							.title(title)
							.author(author)
							.content(content)
							.writeday(writeday)
							.readcnt(readcnt)
							.build();
		
		System.out.println(dto);

		return dto;
	}
	
	public int readcnt(int num) {
		return session.update("com.config.BoardMapper.readcnt", num);
	}
	
	public int update(BoardDTO dto) {
		return session.update("com.config.BoardMapper.update", dto);
	}
	
	public int delete(int num) {
		return session.delete("com.config.BoardMapper.delete", num);
	}
}
