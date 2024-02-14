package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.CookieRequestCache;

import com.example.jwt.JwtFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired 
	private JwtFilter jwtFilter;
	
	//jwt 를 쿠키로 저장할때 쿠키의 이름
	@Value("${jwt.name}")
	private String jwtName;
	
	// favicon.io 가 로그인후 자동 리다일렉트 될때 오류를 일으키기 때문에 미리 Spring Security 에서 배제를 시킨다. 
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> 
		  web.ignoring().antMatchers("/favicon.ico");
	}
		
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
    		AuthSuccessHandler successHandler, AuthFailHandler failHandler, 
			CookieRequestCache cookCache) throws Exception {	
    	System.out.println("SecurityConfig.filterChain");
        // 권한에 따라 허용하는 url 설정
        // /login, /signup 페이지는 모두 허용, 다른 페이지는 인증된 사용자만 허용
        http
//        	.csrf().disable()
            .authorizeRequests()
                .antMatchers("/","/login", "/signup").permitAll()
                .antMatchers("/delete/**").hasRole("ADMIN") // 삭제는 ROLE_ADMIN 만 가능
                .anyRequest().authenticated();

     // login 설정 ( 인증이 필요한 작업 설정 )
        http
            .formLogin()
                .loginPage("/login")            // GET 요청 (login form을 보여줌. loginPage.jsp)
                .loginProcessingUrl("/auth")    // 로그인 화면의 action="auth" method="POST" 요청 (login 창에 입력한 데이터를 처리)
                .usernameParameter("email")	    // login에 필요한 name 값을 email로 설정( name="email" ) (default는 username)
                .passwordParameter("password")	// login에 필요한 name 값을 password 로 설정 (name="password")(default는 password)로 설정
                
                .successHandler(successHandler)
				.failureHandler(failHandler);
                //.failureForwardUrl("/login_fail") //redirect이기 때문에  @GetMapping("/login_fail") 추가 필요함
                //.defaultSuccessUrl("/login_success", true);	    // login에 성공하면 /login_success로 redirect

        http
        .exceptionHandling()  //인증 처리중 예외가 발생했을때의 설정
               //403 forbidden 인 경우 리다일렉트 시킬 경로 설정 
              .accessDeniedPage("/authority_denied");
        
    	// logout 설정
        http
            .logout()
                .logoutUrl("/logout")   //Spring Security 가 자동으로 로그아웃 처리 해줄 경로 설정
                .logoutSuccessUrl("/")	// logout에 성공하면 /로 redirect
                .deleteCookies(jwtName); //로그아웃시  jwt 가 저장된 쿠키 삭제하기 
        
    	//세션을 사용하지 않도록 설정한다.
        http
		.sessionManagement(config->config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		//토큰을 검사하는 필터를 UsernamePasswordAuthenticationFilter 가 동작하기 이전에 동작하도록 설정 한다.
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
		//세션을 사용할수 없기때문에 쿠키케시를 사용하도록 설정한다. 
		.requestCache(config->config.requestCache(cookCache));
        
        return http.build();
    }
    
  //비밀번호를 암호화 해주는 객체를 bean 으로 만든다.
  	@Bean
  	public PasswordEncoder passwordEncoder() { 
  		return new BCryptPasswordEncoder();
  	}

  	//인증 메니저 객체를 bean 으로 만든다.
  	@Bean
  	public AuthenticationManager authenticationManager(HttpSecurity http, 
  			BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService) throws Exception {
  		System.out.println("SecurityConfig.authenticationManager>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
  	    return http.getSharedObject(AuthenticationManagerBuilder.class)
  	      .userDetailsService(userDetailService)
  	      .passwordEncoder(bCryptPasswordEncoder)
  	      .and()
  	      .build();
  	}
  	//쿠키 케시를 bean 으로 만든다. 
  	@Bean
  	public CookieRequestCache getCookieRequestCache() {
  		System.out.println("SecurityConfig.getCookieRequestCache>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
  		return new CookieRequestCache();
  	}
  	
  	
 }