package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dto.LoginDTO;

@Controller
public class TestController {

	// 리턴 타입

	// Model은 없고(리턴 | 파라미터) View은 요청맵핑값이 main 으로 유추  
	@GetMapping("/kkk")
	public void home4() {
		
	}

	// Model은 ("xxx", list) 저장, View는 요청매핑값 list로 유추
	@GetMapping("/list")
	public @ModelAttribute("xxx") List<LoginDTO> home3() {

		List<LoginDTO> list = Arrays.asList(new LoginDTO("홍길동111 ", "111"), new LoginDTO("홍길동222 ", "222"));

		return list;
	}

	// Model은 ("xxx", dto) 저장, View는 요청매핑값 main 으로 유추
	@GetMapping("/main")
	public @ModelAttribute("xxx") LoginDTO home() {

		LoginDTO dto = new LoginDTO("홍길동", "1234");

		return dto;
	}

	// 1. String: 무조건 View 정보
	@GetMapping("/main2")
	public String home2() {
		return "home";
	}
}
