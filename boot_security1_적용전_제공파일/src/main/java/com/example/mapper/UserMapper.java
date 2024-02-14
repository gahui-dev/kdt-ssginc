package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UserDTO;

@Mapper
public interface UserMapper {
    List<UserDTO> getUserList(); // User 테이블 가져오기
    void insertUser(UserDTO userVo); // 회원 가입
    UserDTO getUserByEmail(String email); // 회원 정보 가져오기
    UserDTO getUserById(Long id);
    void updateUser(UserDTO userVo); // 회원 정보 수정
    void deleteUser(Long id); // 회원 탈퇴
}