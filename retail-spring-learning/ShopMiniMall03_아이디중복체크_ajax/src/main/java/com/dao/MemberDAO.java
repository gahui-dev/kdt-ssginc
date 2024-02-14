package com.dao;

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
}
