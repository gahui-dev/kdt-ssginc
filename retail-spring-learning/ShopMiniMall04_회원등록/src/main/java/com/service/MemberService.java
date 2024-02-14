package com.service;

import com.dto.MemberDTO;

public interface MemberService {
	public MemberDTO idCheck(String userid);
	public int memberAdd(MemberDTO dto);
}
