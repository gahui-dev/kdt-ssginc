package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;

import io.swagger.annotations.ApiOperation;

@RestController // @Controller + @ResponseBody
public class TestController {
	
	@ApiOperation(value="홍길동 응답")
	@GetMapping("/main6")
	public ResponseEntity<LoginDTO> main6() {
		LoginDTO dto = new LoginDTO("leegahee", "1234");
		
		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	// http://localhost:8090/app/main5/1/aaa
	@GetMapping("/main5/{num}/{name}")
	public String main5(@PathVariable("num") int num, @PathVariable("name") String name) {
		System.out.println(num + " " + name);
		return "Hello";
	}

	// http://localhost:8090/app/main4/정수
	@GetMapping("/main4/{num}")
	public String main4(@PathVariable("num") int num) {
		System.out.println(num);
		return "Hello";
	}

	@GetMapping("/main")
	public String main() {
		return "Hello";
	}

	@GetMapping("/main2")
	public LoginDTO main2() {
		LoginDTO dto = new LoginDTO("leegahee", "1234");
		return dto;
	}

	@GetMapping("/main3")
	public List<LoginDTO> main3() {
		List<LoginDTO> list = Arrays.asList(new LoginDTO("abcd", "1111"), new LoginDTO("efgh", "2222"));
		return list;
	}
}
