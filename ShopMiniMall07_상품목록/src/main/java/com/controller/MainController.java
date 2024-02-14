package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class MainController {
	@Autowired
	GoodsService gService;
	
	@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue = "top") String gCategory, Model m ) {
		
		// Goods 테이블 카테고리(top, dress, outer, bottom) 별로 데이터 검색 
		List<GoodsDTO> list = gService.goodsList(gCategory);
		m.addAttribute("goodsList", list);
		
		return "main";	// /WEB-INF/views/main.jsp
	}
}
