package com.example.dto;

import java.util.List;

public class MemberDTO {

	String userid;
	String passwd;
	
	//email 저장
	List<String>  email;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String userid, String passwd, List<String> email) {
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
	}

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
