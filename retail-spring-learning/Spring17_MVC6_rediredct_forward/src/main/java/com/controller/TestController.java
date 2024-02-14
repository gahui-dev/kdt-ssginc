package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	// redirect
	@GetMapping("/forward")
	public String forward(Model m) {
		System.out.println("TestController.forward");

		m.addAttribute("userid", "홍길동");

		return "forward:main"; // /WEB-INF/views/main.jsp
	}

	// redirect
	@GetMapping("/redirect")
	public String redirect(Model m) {
		System.out.println("TestController.redirect");

		m.addAttribute("userid", "홍길동");

		return "redirect:main"; // /WEB-INF/views/main.jsp
	}

//		// redirect
//		@GetMapping("/redirect")
//		public String redirect() {
//			System.out.println("TestController.redirect");
//			return "redirect:main"; // /WEB-INF/views/main.jsp
//		}

	// http://localhost:8090/app/main
	@GetMapping("/main")
	public String home() {
		System.out.println("TestController.main");
		return "home";
	}

}
