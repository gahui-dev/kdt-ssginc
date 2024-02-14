package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.LoginDTO;

@Controller
public class TestController {

	//ajax.jsp
	@GetMapping("/")
	public String main() {
		
		return "ajax";
	}

	@GetMapping("/main")
	@ResponseBody
	public LoginDTO home() {
		
		//LoginDTO 생성
		LoginDTO dto = new LoginDTO("홍길동", "1234");
		
		// LoginDTO -> JSON
		/*
		   {key:"홍길동",
		    key:"1234"}
		*/
		
		return dto;
	}
	@GetMapping("/main2")
	@ResponseBody
	public List<LoginDTO> home2() {
		
		List<LoginDTO> list = 
				Arrays.asList(new LoginDTO("홍길동1", "1234"),
						new LoginDTO("홍길동2", "1234"));
		
		return list;
	}
	@GetMapping("/main3")
	@ResponseBody
	public String home3() {
		
		return "hello";
	}
}



