package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService gService;
	
	@GetMapping("/goodsRetrieve")
	@ModelAttribute("goodsRetrieve")
	public GoodsDTO goodsRetrieve(@RequestParam String gCode) {

		// GoodsDTO 요청하면 모델은 goodsdto 뷰는 요청매핑값 유추 
		// @ModelAttribute 명시적 키값 
		GoodsDTO dto = gService.goodsRetrieve(gCode);
		return dto;
	}
}
