package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UserDTO;
import com.example.service.UserService;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) { 
    	System.out.println("UserController.home");

        return "home";
    }

    @GetMapping("/userList")
    public String getUserList(Model model) { 
        List<UserDTO> userList = userService.getUserList();
        model.addAttribute("list", userList);
        return "userList";
    }

    @GetMapping("/login")
    public String loginPage() { 
     
        return "loginPage";
   
    }

    @GetMapping("/signup")
    public String signupPage() {  // 회원 가입 페이지
     
       return "signupPage";
     
    }

    @PostMapping("/signup")
    public String signup(UserDTO userVo) { // 회원 가입
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

    @GetMapping("/update")
    public String editPage(Model model) { // 회원 정보 수정 페이지
    	// id 이용하여 User 정보를 얻고 Model에 저장한 후 editPage에서 출력하기
        return "editPage";
    }

    @PostMapping("/update")
    public String edit(UserDTO userVo) { // 회원 정보 수정
    	// id 와 일치하는 User를 UserDTO 값으로 수정하기
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete() { // 회원 탈퇴
    	// id 이용하여 일치하는 회원 삭제하기
        return "redirect:/";
    }
}