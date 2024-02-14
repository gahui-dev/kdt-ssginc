package com.service;

import java.util.Properties;


public class UserService {
	// key/value 저장, 일반적으로 String/String 인 경우 주로 사
	Properties props;
	
	public Properties getProps() {
		return props;
	}

	// DI
	public void setProps(Properties props) {
		this.props = props;
	}

	public String getMesg() {
		return "hello world";
	}
}
