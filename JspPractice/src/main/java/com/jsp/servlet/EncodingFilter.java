package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding;

	/*
	 * FilterConfig 필터가 초기화 되는 시점에 호출되는 init() 메서드의 매개변수로 전달되는 객체 web.xml에서
	 * <init-param> 태그를 통해 작성해둔 설정값 정보들과 ServletContext에 대한 참조를 가지고 있음
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/*
		 * getInitParameter() ServletConfig의 매서드
		 *
		 * 미리 web.xml 에다가 지정해둔 파라미터들의 값을 얻어 올 수 있습니다.
		 */
		this.encoding = fConfig.getInitParameter("encoding"); // utf-8
		System.out.println("init()");
		System.out.println("encoding - " + encoding);

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	/*
	 * getMethod() HttpServletRequest의 매서드
	 *
	 * request.getMethod().equals("GET") 일 경우 GET 으로 넘어오는 경우엔 true를 반환
	 * request.getMethod().equals("POST") 일 경우 POST 로 넘어오는 경우엔 true를 반환
	 */

	/*
	 * qualsIgnoreCase()
	 *
	 * equals는 대소문자 구분 equalsIgnoreCase는 대소문자 구분x
	 * 
	 * 
	 * //요청 request가 post인 경우 xml에 encoding이란 이름으로 저장해둔 파라미터 값(utf-8)으로 인코딩하자 if
	 * (((HttpServletRequest) request).getMethod().equalsIgnoreCase("post")) {
	 * request.setCharacterEncoding(encoding); //원래 post를 받아올때 하던 인코딩 방식과 동일 }
	 */
	/*
	 * doFilter()
	 *
	 * 요청(Request)와 응답(Response)쌍이 체인을 통과할 때마다 컨테이너에서 호출됩니다.
	 */

}