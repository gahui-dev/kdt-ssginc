package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/main")
	public String home() {
		if(true) {
			throw new NullPointerException("NullPointerException 발생 111");
		}
		return "home";
	}
	
	@GetMapping("/main2")
	public String home2() {
		if(true) {
			throw new ArithmeticException("ArithmeticException 발생 222");
		}
		return "home";
	}
	
	// 예외처리
	@ExceptionHandler({NullPointerException.class, ArithmeticException.class})
	public String errorPage(Exception e, Model m) {
		System.out.println(">>>>>>>>>> Exception: " + e);
		m.addAttribute("exception", e.getMessage());
		return "error";  
	}
}
