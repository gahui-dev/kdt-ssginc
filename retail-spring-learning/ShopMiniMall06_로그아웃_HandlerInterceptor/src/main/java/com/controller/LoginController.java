package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	MemberService mService;
	
	@GetMapping("/LoginUIServlet")
	public String loginUI() {
		return "loginForm";	// /WEB-INF/views/main.jsp
	}
	
	@GetMapping("/LoginServlet")
	public String login(@RequestParam HashMap<String, String> map, HttpSession session) {
		MemberDTO dto = mService.login(map);
		String nextPage = null;
		
		if(dto != null) {
			// 로그인 성공, 세션 저장
			session.setAttribute("login", dto);
			nextPage = "redirect:main";
		} else {
			// id와 pw 틀린 경우, 다시 로그인하도록 처리
			nextPage = "member/loginFail";
		}
		return nextPage;
	} 
	
	
	// 로그아웃
	@GetMapping("/LogoutServlet")
	public String logout(HttpSession session) {
		// 로그인 여부 확인 => HandlerInterceptor 사용 
		session.invalidate();
		
		
		return "redirect:main";
	}
}
