package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
public class TestController {
	@GetMapping("/main")
	public String main() {
		System.out.println("test");
		return "Hello";
	}
}
