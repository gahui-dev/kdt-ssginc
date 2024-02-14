package com.example.dto;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDTO {
	List<BoardDTO> list;
	int totalCount;
	int perPage = 3;
	int curPage;
}
