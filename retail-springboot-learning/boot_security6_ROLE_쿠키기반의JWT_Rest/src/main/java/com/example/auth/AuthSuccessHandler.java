package com.example.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.CookieRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.example.dto.MemberDTO;
import com.example.jwt.JwtUtil;


/*
 *  로그인 하지 않은 상태로 인증이 필요한 경로를 직접 요청했을경우에  로그인폼으로 자동 리다일렉트 된다.
 *  그 후에 로그인 성공을 한다면 원래 요청했던 경로로 자동 리다일렉트 되도록 하기 위해서 이 핸들러가 필요하다.
 */
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	//Jwt 토큰 유틸
	@Autowired 
	private JwtUtil jwtUtil;
	
	//jwt 를 쿠키로 저장할때 쿠키의 이름
	@Value("${jwt.name}")
	private String jwtName;
	
	//쿠키 유지시간
	@Value("${jwt.cookie.expiration}")
	private int cookieExpiration;
	
	//로그인 성공후 원래 목적지로 리다일렉트 시켜주기 위해 필요한 객체 
	@Autowired
	private CookieRequestCache requestCache;
	//세션을 사용하지 않기 때문에 CookieRequestChache 를 사용해야 한다.
	@Autowired
    public AuthSuccessHandler(CookieRequestCache requestCache) {
        super.setRequestCache(requestCache);
    }
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
    	
    	System.out.println("2. AuthSuccessHandler.onAuthenticationSuccess");
    	System.out.println("Authentication:>>>>>>>>>>>>>" + authentication);
    	System.out.println("3. authentication.getName() >>>>>>>>" + authentication.getName()); // aaa@naver.com
    	
    	//여기 까지 실행순서가 넘어오면 인증을 통과 했으므로 토큰을 발급해서 응답한다.
    	User u = (User)authentication.getPrincipal();
		String jwtToken=jwtUtil.generateToken(u.getUsername());
		// JWT를 쿠키에 담아 응답 (쿠키에 공백문자는 에러를 일으키기 때문에 공백대신에  "+" 를 사용함)
        Cookie cookie = new Cookie(jwtName, "Bearer+"+jwtToken);
        cookie.setMaxAge(cookieExpiration); // 쿠키 유지 시간 초 단위로 설정
        cookie.setHttpOnly(true); //웹브라우저에서 JavaScript에서 접근 불가 하도록 설정 
        cookie.setPath("/"); // 모든 경로에서 쿠키를 사용할수 있도록 설정 
        response.addCookie(cookie);
        
response.addHeader("jwtAuthToken", "Bearer+"+jwtToken);
        
    	SavedRequest cashed=requestCache.getRequest(request, response);
    	System.out.println("AuthSuccessHandler.onAuthenticationSuccess.SavedRequest>> " + cashed);
    	System.out.println("4. AuthSuccessHandler.onAuthenticationSuccess.SavedRequest>> " + cashed);
    	System.out.println("AuthSuccessHandler.onAuthenticationSuccess.SavedRequest>> " + cashed);
        if(cashed!=null) {
//        	RequestDispatcher rd=request.getRequestDispatcher("/users/login_success");
//        	rd.forward(request, response);
        	response.sendRedirect("login_success");
        }else {
        	super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}






