package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	// 회원가입화면 보기
	@GetMapping("/MemberUIServlet")
	public String memberUI() {
		return "memberForm";
	}
}
