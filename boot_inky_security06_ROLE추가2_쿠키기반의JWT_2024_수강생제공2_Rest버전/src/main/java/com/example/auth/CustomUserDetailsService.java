package com.example.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dto.MemberDTO;
import com.example.service.MemberService;


/*
 *  Spring Security 에서 중요한 역활을 하는 서비스 만들기 
 *  
 *  - UserDetailsService 인터페이스를 구현해서 만든다
 */

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberService service;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("3. CustomUserDetailsService.loadUserByUsername: " + email);
		System.out.println("email>>>>>>>>>>>" + email);
		MemberDTO memberDTO=service.getUserByEmail(email);
		if(memberDTO != null) {
			List<SimpleGrantedAuthority> list=new ArrayList<>();
			list.add(new SimpleGrantedAuthority(memberDTO.getRole()));
			
			UserDetails userDetails=new org.springframework.security.core.userdetails
					.User(memberDTO.getEmail(), memberDTO.getPassword(), list);
			System.out.println("3. UserDetails>>>>>>>>>>..." + userDetails);
	//org.springframework.security.core.userdetails.User [Username=hong@daum.net, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[USER]]
			   return userDetails;
		}else {
			throw new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다.");
		}
	}
}














