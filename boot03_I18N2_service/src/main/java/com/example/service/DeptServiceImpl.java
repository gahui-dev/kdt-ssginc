package com.example.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class DeptServiceImpl {
	@Autowired
	MessageSource ctx;
	
	public String getMesg() {
		
		String mesg = ctx.getMessage("greet", new String[] {"하이", "~~~"}, Locale.KOREA);
		System.out.println(mesg);
		
		return "hello";
	}
}
