package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/main")
	public String home() {
		System.out.println("TestController.main");
		return "home";
	}
	
	@GetMapping("/main2")
	public String home2() {
		System.out.println("TestController.main2");
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("TestController.login");
		return "home";
	}
	
	@GetMapping("/loginCheck/mypage")
	public String mypage() {
		System.out.println("TestController.mypage");
		return "home";
	}
	
	@GetMapping("/loginCheck/logout")
	public String logout() {
		System.out.println("TestController.logout");
		return "home";
	}
}
