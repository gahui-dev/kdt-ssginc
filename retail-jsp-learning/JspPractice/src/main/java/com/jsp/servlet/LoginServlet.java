package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.PersonDTO;
import com.jsp.service.LoginService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LoginService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        this.service = LoginService.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("login"));
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		int level = Integer.parseInt(request.getParameter("level"));
		
		PersonDTO personDto = new PersonDTO();

		personDto.setUserid(userid);
		personDto.setPassword(password);
		personDto.setLevel(level);
		
		PersonDTO result = service.loginPersonInfo(personDto);
		
		if(result != null) {
			System.out.println("로그인 성공 ");
			HttpSession session = request.getSession(true);
			
			session.setAttribute("userid", result.getUserid());
			session.setAttribute("level", result.getLevel());
			session.setAttribute("name", result.getName());
			
			response.sendRedirect("main");
		} else {
			request.setAttribute("msg", "아이디와 비밀번호를 확인해주세요. ");
			doGet(request, response);
			
//			RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("login"));
//			rd.forward(request, response);	
		}
	}

}
