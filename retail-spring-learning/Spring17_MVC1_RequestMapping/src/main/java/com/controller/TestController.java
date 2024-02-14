package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	// http://localhost:8090/app/main
	@GetMapping("/main")
	public String home() {
		System.out.println("TestController.main");
		return "/WEB-INF/views/home.jsp";
	}

	// http://localhost:8090/app/aaa/bbb
	@GetMapping("/aaa/bbb")
	public String home2() {
		System.out.println("TestController.main");
		return "/WEB-INF/views/home.jsp";
	}

	// http://localhost:8090/app/cccdefd
	@GetMapping("/ccc*")
	public String home3() {
		System.out.println("TestController.main");
		return "/WEB-INF/views/home.jsp";
	}

	// http://localhost:8090/app/ddd/abc/eee
	@GetMapping("/ddd/*/eee")
	public String home4() {
		System.out.println("TestController.main");
		return "/WEB-INF/views/home.jsp";
	}
}
