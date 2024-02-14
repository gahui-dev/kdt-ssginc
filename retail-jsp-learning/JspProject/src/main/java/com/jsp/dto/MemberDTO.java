package com.jsp.dto;

public class MemberDTO {
	private int userid;
	private String username;
	private String password;
	
	public int getUserid() {
		return this.userid;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
