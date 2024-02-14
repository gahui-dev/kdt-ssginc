package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	// 회원가입화면 보기
	@GetMapping("/MemberUIServlet")
	public String memberUI() {
		return "memberForm";
	}
	
	// 멤버 아이디 중복 확인 
	@GetMapping(value = "/MemberIdCheckServlet", produces = "text/plain;charset=utf-8")
	@ResponseBody // jackson-bind 의존성 추가 
	public String idCheck(@RequestParam String userid) {
		// 문자열 리턴대신 0이나 1 같은 플래그를 리턴해줘야함 
		
		String mesg = "아이디 중복";		
		MemberDTO dto = mService.idCheck(userid);
		if(dto == null) {
			mesg = "아이디 사용 가능";
		} 
		
		return mesg;
	}
}
