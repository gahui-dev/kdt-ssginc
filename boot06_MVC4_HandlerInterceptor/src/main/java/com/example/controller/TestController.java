package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/main")
	public String main() {
		System.out.println("main");
		return "home";
	}
	@GetMapping("/login")
	public String login() {
		System.out.println("login >>");
		return "home";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		System.out.println("mypage >> ");
		return "home";
	}
}
