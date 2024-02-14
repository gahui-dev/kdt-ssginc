package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;

@Controller
public class MemberController {
	
    @Autowired
    private MemberService userService;

    @GetMapping("/")
    public String home(Model model) { 
        return "home";
    }

    @GetMapping("/signup")
    public String signupPage() {  // 회원 가입 페이지
       return "signupPage";
    }

    @PostMapping("/signup")
    public String signup(MemberDTO userVo) { // 회원 가입
    	System.out.println(userVo);
        try {
            userService.signup(userVo);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginPage() { 
        return "loginPage";
   
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
    public String getUserList(Model model) { 
        List<MemberDTO> userList = userService.getUserList();
        model.addAttribute("list", userList);
        return "userList";
    }



  
    @GetMapping("/updateForm")
    public String editPage(Model model) { // 회원 정보 수정 페이지
    	// email 이용하여 User 정보를 얻고 Model에 저장한 후 editPage에서 출력하기
    	User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	// u.getUsername() 값이 email 값이다.
    	MemberDTO memberDTO = userService.getUserByEmail(u.getUsername());
        model.addAttribute("user", memberDTO);
    	return "editPage";
    }

//     @PostMapping("/update")   //JWT 전에는 @PostMapping
    @GetMapping("/update")
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

    @GetMapping("/delete")
    public String delete() { // 회원 탈퇴
    	// email 이용하여 일치하는 회원 삭제하기
    	User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	 if (u.getUsername() != null) {
             userService.delete(u.getUsername());
         }
    	return "forward:userList";
    }
    
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