package com.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.dto.LoginDTO;

@Controller
public class TestController {
	
	@GetMapping("/main")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView();
		
		// 모델지정
		mav.addObject("email", "mail@test.com");
		mav.addObject("phone", "010-0000-1234");
		
		// 뷰지정 
		mav.setViewName("home5"); // /WEB-INF/views/home5.jsp
		
		return mav;
	}
	
	@GetMapping("/main7")
	public String home7(@ModelAttribute("yyy") ArrayList<LoginDTO> list) {
				
		list.add(new LoginDTO("이가희", "1234"));
		list.add(new LoginDTO("이순신", "5678"));
		
		return "home4";
	}
	
	@GetMapping("/main6")
	public String home6(@ModelAttribute("xxx") LoginDTO dto) {
		
		dto.setUserid("이가희 dto key"); 
		dto.setPasswd("dto");
		
		// CoC 혼란스러울 수 있음 
		// 명시적으로 key 값을 줄 수 있음
		// @ModelAttribute
		
		return "home3";
	}
	
	@GetMapping("/main5")
	public String home5(LoginDTO dto) {
		
		// Model 저장 ==> JSP 에서 출력 가능 
		dto.setUserid("이가희 dto"); 
		dto.setPasswd("dto");
		
		// LoginDTO는 Model로 처리됨
		// 내부적으로 (key, value)로 저장
		// CoC 관례에 따라 클래스 이름으로 key 저장
		// 실제로 ("loginDTO", dto)
		
		return "home2";
	}
	
	@GetMapping("/main4")
	public String home4(Map<String, String> map) {
		
		// Model 저장 ==> JSP 에서 출력 가능 
		map.put("userid", "이가희 map"); 
		map.put("passwd", "123456 map");
		
		return "home";
	}
	
	@GetMapping("/main3")
	public String home3(Model model) {
		
		// Model 저장 ==> JSP 에서 출력 가능 
		model.addAttribute("userid", "이가희1234");
		model.addAttribute("passwd", "123456");
		
		return "home";
	}
	
	// http://localhost:8090/app/main
	@GetMapping("/main2")
	public String home2(HttpServletRequest request) {
		
		// Model 저장 ==> JSP 에서 출력 가능 
		request.setAttribute("userid", "이가희");
		request.setAttribute("passwd", "1234");
		
		return "home";
	}
}
