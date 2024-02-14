package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.dto.MemberDTO;
import com.example.mapper.MemberMapper;

@SpringBootApplication
@PropertySource(value = "classpath:custom.properties")
public class DemoApplication {
	
	 @Autowired
	    private MemberMapper userMapper;

	 @PostConstruct
	    public void initUsers() {
			
		 	//실행전 DB 데이터 모두 삭제
		 	userMapper.deleteAll();
		 
		 
//			String samplePwd= "1234";
			String samplePwd= new BCryptPasswordEncoder().encode("1234");
			
			MemberDTO dto = new MemberDTO();
			dto.setName("홍");
			dto.setUsername("홍길동");
			dto.setEmail("hong@daum.net");
			dto.setPassword(samplePwd);
			dto.setAddress("서울");
			dto.setPhone("010");
			dto.setWebsite("다음");
			dto.setCompany("다음");
			dto.setRole("ROLE_USER");
		
			userMapper.insertUser(dto);
			
			
			dto = new MemberDTO();
			dto.setName("이");
			dto.setUsername("이순신");
			dto.setEmail("lee@google.com");
			dto.setPassword(samplePwd);
			dto.setAddress("부산");
			dto.setPhone("010");
			dto.setWebsite("구글");
			dto.setCompany("구글");
			dto.setRole("ROLE_ADMIN");
			
			userMapper.insertUser(dto);
			
			
			
	    }	
	 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
		
	}

}
