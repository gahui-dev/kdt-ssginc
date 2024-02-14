package com.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO dao;
	
	@Override
	public MemberDTO idCheck(String userid) {		
		return dao.idCheck(userid);
	}

	@Override
	public int memberAdd(MemberDTO dto) {
		return dao.memberAdd(dto);
	}

	@Override
	public MemberDTO login(HashMap<String, String> map) {
		return dao.login(map);
	}

}
