package com.dto;

import java.util.List;

public class MemberDTO {
	private String userid;
	private String passwd;

	// 이메일 저장
	List<String> email;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", email=" + email + "]";
	}
}
