package com.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
  
import com.dto.LoginDTO;

@Controller
public class TestController {
	@GetMapping("/")
	public String main() {
		return "ajax";
	}

	@PostMapping("/main")
	// 클라이언트에서 {key: value}
	// json의 키값이랑 dto의 변수명이 같아야 함
	public String home(@RequestBody LoginDTO dto) {
		System.out.println(">>>>>>>>>>>>> LoginDTO : " + dto);
		return "ajax";
	}

	@PostMapping("/main2")
	// 클라이언트에서 {key: value}
	// json의 키값이랑 dto의 변수명이 같아야 함
	public String home(@RequestBody ArrayList<LoginDTO> list) {
		System.out.println("ArrayList<LoginDTO>" + list);
		return "ajax";
	}
}
