package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDTO;
import com.example.mapper.UserMapper;

@Service
public class UserService {
	
    @Autowired
    private UserMapper userMapper;


    public List<UserDTO> getUserList() {
        return userMapper.getUserList();
    }

    public UserDTO getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public void signup(UserDTO userVo) { // 회원 가입
            userMapper.insertUser(userVo);
        
    }

    public void edit(UserDTO userVo) { // 회원 정보 수정
        userMapper.updateUser(userVo);
    }

    public void delete(Long id) { // 회원 탈퇴
        userMapper.deleteUser(id);
    }

  
}