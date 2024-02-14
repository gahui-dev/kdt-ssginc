package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.service.DeptServiceImpl;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Service 얻기
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		DeptServiceImpl service = ctx.getBean("xxx", DeptServiceImpl.class);
		System.out.println(service.getMesg());
	}

}
