package com.service;

public class DeptServiceImpl {
	String driver;
	String url;
	String userid;
	String passwd;
	
	public DeptServiceImpl() {
		System.out.println("DeptServiceImpl 생성자");
	}
	
	// 기능 처리
	public String getMesg() {
		return "Hello World";
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@Override
	public String toString() {
		return "DeptServiceImpl [driver=" + driver + ", url=" + url + ", userid=" + userid + ", passwd=" + passwd + "]";
	}
}
