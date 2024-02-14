package com.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean  // 객체 생성
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		System.out.println("SecurityConfig.filterChain");
		
		// 누구 허용할지 안할지 결정 
		// 허용 - 로그인 페이지(/signup)
		http
			.authorizeRequests()
				.antMatchers("/login", "/signup").permitAll()
				.anyRequest().authenticated(); // 이외 요청은 인증 처리해라 
		
		// 로그인 화면 설정
		http
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/auth") // 입력한 id와 pw를 체크할 SpringSecurity의 bean 
				.usernameParameter("email")
				.passwordParameter("password")
				.failureForwardUrl("/login_fail")// 로그인 실패 후 타겟 
				.defaultSuccessUrl("/login_success", true); // 로그인 성공 후 타겟 
		
		// 로그아웃
		http
			.logout()
				.logoutUrl("/logout") // 지정된 요청값으로 요청하면 자동으로 로그아웃 처리
				.logoutSuccessUrl("/"); // 로그아웃 성공 후 타겟 
		
		return http.build();
	}
}
