package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	// http://localhost:8090/app/main
	@GetMapping("/main")
	public String home() {
		System.out.println("TestController.main");
		return "home";
	}
}
