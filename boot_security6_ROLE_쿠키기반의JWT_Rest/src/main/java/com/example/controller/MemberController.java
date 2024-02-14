package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MemberDTO;
import com.example.dto.TokenDTO;
import com.example.jwt.JwtUtil;
import com.example.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	AuthenticationManagerBuilder authenticationManagerBuilder;
	
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Value("${jwt.name}")
	String tokenKey;
	
    @Autowired
    private MemberService userService;

//    @GetMapping("/")
//    public String home(Model model) { 
//        return "home";
//    }

//    @GetMapping("/signup")
//    public String signupPage() {  // 회원 가입 페이지
//       return "signupPage";
//    }

    @PostMapping("/signup")
    public ResponseEntity<MemberDTO> signup(@RequestBody MemberDTO userVo) { // 회원 가입
    	System.out.println("MemberController.signup: " + userVo);
   
            userService.signup(userVo);
  
        return ResponseEntity.ok(userVo);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody MemberDTO dto) { 
    	
    	System.out.println("MemberController.login:>>>> " + dto);
    	 UsernamePasswordAuthenticationToken authenticationToken =
                 new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

         Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
         SecurityContextHolder.getContext().setAuthentication(authentication);

         String jwt = jwtUtil.generateToken(dto.getEmail());

         HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.add(tokenKey, "Bearer+" + jwt);

         System.out.println("MemberController.jwt: >>>" + jwt);
         return new ResponseEntity<>(new TokenDTO("Bearer+" + jwt), httpHeaders, HttpStatus.OK);
   
    }
   
    // SpringSecurity에서 자동으로 logout 처리해준다.
//    @GetMapping("/logout")
//    public String logout(HttpSession session) { 
//    	
//    	String nextPage = null;
//    	MemberDTO dto = (MemberDTO)session.getAttribute("login");
//    	if(dto==null) {
//    		nextPage = "redirect:login";
//    	}else {
//    		session.invalidate();
//    		nextPage = "redirect:/";
//    	}
//        return nextPage;
//   
//    }
	//////////////////////////////////////////////
//	@PostMapping("/auth")
//	public String auth(MemberDTO dto, HttpSession session) { 
//		MemberDTO xxx = userService.auth(dto);
//		String nextPage = null;
//		if(xxx!=null) {
//		  session.setAttribute("login", xxx);
//		  nextPage = "login_success";
//		}else {
//			nextPage = "login_fail";
//		}
//		// xxx가 null 이 아니면 session에 저장
//		return nextPage;
//	}
	//////////////////////////////////////////////
	
	
	
	

    @GetMapping("/userList")
    public List<MemberDTO> getUserList() { 
    	System.out.println("MemberController.userList>>>>>>>>>>>>>>>>>>>");
    	List<MemberDTO> userList = userService.getUserList();
        
        return userList;
    }

    @GetMapping("/update")
    public MemberDTO update(Model model) { // 회원 정보 수정 페이지
    	System.out.println("MemberController.update>>>>>>>>>>>>>>>>>>>");
    	// email 이용하여 User 정보를 얻고 Model에 저장한 후 editPage에서 출력하기
    	User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	// u.getUsername() 값이 email 값이다.
    	MemberDTO memberDTO = userService.getUserByEmail(u.getUsername());
       
    	return memberDTO;
    }

    @PostMapping("/update")
    public String edit(MemberDTO dto) { // 회원 정보 수정
    	System.out.println("MemberController.update>>>"+ dto);
    	// email 와 일치하는 User를 UserDTO 값으로 수정하기
    	System.out.println(">>>>"+ SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    	User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println("User.edit:" + u);
    	System.out.println("User.edit.u.getUsername():" + u.getUsername());
    	dto.setEmail(u.getUsername());
    	userService.edit(dto);
    	return "redirect:/";
    }

//	/*
//	 * @GetMapping("/delete") public String delete(HttpSession session) { // 회원 탈퇴
//	 * // email 이용하여 일치하는 회원 삭제하기 User u = (User)
//	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); if
//	 * (u.getUsername() != null) { userService.delete(u.getUsername()); } // 흔적 지우기
//	 * session.invalidate();
//	 * 
//	 * // 시큐리티 인증정보 없애기 SecurityContextHolder.getContext().setAuthentication(null);
//	 * 
//	 * return "redirect:/login"; // redirect로 처리하면 CustomUserDetailsService 에서 무한루프
//	 * 실행됨
//	 * 
//	 * }
//	 */
    
    @GetMapping("/login_success")
    public String login_success() { // 로그인 성공시
        return "login_success";
    }
 // 로그인이 post방식으로 처리되어 failureForwardUrl인  login_fail로 넘어왔기 때문에 반드시 @PostMapping으로 처리해야 된다.
    @PostMapping("/login_fail")
    public String login_fail() { // 로그인 실패시
        return "login_fail";
    }
    @GetMapping("/authority_denied")
    public String authority_denied() {  // 회원 가입 페이지
     
       return "authority_denied";
     
    }
}