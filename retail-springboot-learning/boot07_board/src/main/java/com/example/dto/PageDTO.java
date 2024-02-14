package com.example.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("PageDTO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PageDTO {
	List<BoardDTO> list; // 한페이지에 보여줄 데이터 
	
	int totalCount; // 전체 레코드 갯수 
	int perPage=3; // 페이지당 보여줄 레코드 갯수 
	int curPage; // 페이지 번호 
}
