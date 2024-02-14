package com.example.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Alias("BoardDTO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDTO {
	int num;
	String title;
	String author;
	String content;
	String writeday;
	int readcnt;
}
