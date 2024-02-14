package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@Value("${server.servlet.context-path}")
	String path;
	
	// 	http://localhost:8090/app/main
	@GetMapping("/main")
	public String main() {
		System.out.println(path);
		return "hello";
	}
}
