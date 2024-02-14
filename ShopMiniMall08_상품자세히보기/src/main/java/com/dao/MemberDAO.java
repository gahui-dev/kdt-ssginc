package com.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate session;
	
	public MemberDTO idCheck(String userid) {
		return session.selectOne("MemberMapper.idCheck", userid);
	}
	
	public int memberAdd(MemberDTO dto) {
		return session.insert("MemberMapper.memberAdd", dto);
	}
	
	public MemberDTO login(HashMap<String, String> map) {
		return session.selectOne("MemberMapper.login", map);
	}
}
