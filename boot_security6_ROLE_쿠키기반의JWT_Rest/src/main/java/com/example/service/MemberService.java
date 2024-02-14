package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDTO;
import com.example.mapper.MemberMapper;

@Service
public class MemberService {
	
    @Autowired
    private MemberMapper userMapper;

    public MemberDTO auth(MemberDTO dto) {
    	return userMapper.auth(dto);
    }
    
    public List<MemberDTO> getUserList() {
        return userMapper.getUserList();
    }

    public MemberDTO getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public MemberDTO getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
    
 // 암호화 객체 생성
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public void signup(MemberDTO memberDTO) { // 회원 가입
    	    // password는 암호화해서 DB에 저장 
    		memberDTO.setPassword(passwordEncoder().encode(memberDTO.getPassword()));
            userMapper.insertUser(memberDTO);
        
    }

    public void edit(MemberDTO memberDTO) { // 회원 정보 수정
    	// password는 암호화해서 DB에 저장      
    	memberDTO.setPassword(passwordEncoder().encode(memberDTO.getPassword()));
        userMapper.updateUser(memberDTO);
    }

    public void delete(String email) { // 회원 탈퇴
        userMapper.deleteUser(email);
    }

  
}