package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {
	// redirect
	@GetMapping("/redirect")
	public String redirect(Model m) {
		System.out.println("TestController.redirect");

		m.addAttribute("userid", "홍길동");

		return "redirect:main"; // /WEB-INF/views/main.jsp
	}

	// redirect-flash-scope
	// flash
	@GetMapping("/flash")
	public String flash(RedirectAttributes m) {
		System.out.println("TestController.redirect");

		m.addFlashAttribute("userid", "홍길동");

		return "redirect:main"; // /WEB-INF/views/main.jsp
	}

	// http://localhost:8090/app/main
	@GetMapping("/main")
	public String home() {
		System.out.println("TestController.main");
		return "home";
	}
	
	// A이외의 서블릿
	

}
