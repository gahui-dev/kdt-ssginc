package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	// 	http://localhost:8090/app/main
	@GetMapping("/main")
	public String main() {
		return "hello";
	}
}
