package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.LoginDTO;

@Controller
public class TestController {
	@GetMapping("/")
	public String main() {
		return "ajax";
	}
	
	
	@GetMapping("/main")
	@ResponseBody
	public LoginDTO home() {
		LoginDTO dto = new LoginDTO("이가희", "1234");
		
		/*
		 * {key: "이가희",
		 * 	key: "1234"}
		 * */
		
		return dto;
	}
	
	@GetMapping("/main2")
	@ResponseBody
	public List<LoginDTO> home2() {
		List<LoginDTO> list = Arrays.asList(new LoginDTO("이가희11", "1234"), new LoginDTO("이가희22", "5678"));
		
		return list;
	}
	
	@GetMapping("/main3")
	@ResponseBody
	public String home3() {
		
		return "hello";
	}
}
