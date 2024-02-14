package com.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean  // 객체생성
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		System.out.println("SecurityConfig.filterChain");
		
		//누구 허용할지 안할지 결정 
		// 허용할 페이지: /signup, /login
		
		http
			.authorizeRequests()
				.antMatchers("/login","/signup").permitAll() // /login과 /signup 요청은 허용
				.anyRequest().authenticated(); // 이외 요청은 인증 처리 해라~
		
		// 로그인 화면 설정
		http
			.formLogin()
				.loginPage("/login") // 로그인 화면설정 ==> id와 pw입력
				.loginProcessingUrl("/auth")// 입력한 id와 pw를 체크할 Security 빈
				.usernameParameter("email")  // 로그인 화면에서 입력한  id값
				.passwordParameter("password")// 로그인 화면에서 입력한  pw값
				// 로그인 실패 했을 때 화면
				.failureForwardUrl("/login_fail")
				// 로그인 성공후 보여줄 타겟
				// true로 지정하면 바로 타겟으로 감. 기본은 false이면 이전 URL 로 감.
				.defaultSuccessUrl("/login_success", true);   
		
		// 로그아웃
		http
			.logout()
				.logoutUrl("/logout") // 지정된 요청값으로 요청하면 자동으로  로그아웃 처리 해줌
				.logoutSuccessUrl("/"); // 로그아웃 성공후 타겟
		
		return http.build();
	}
}
