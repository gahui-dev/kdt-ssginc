package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.UserDTO;
import com.jsp.service.UserService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        this.service = UserService.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("signIn"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		
		UserDTO userDto = new UserDTO();
		userDto.setMail(mail);
		userDto.setPassword(password);
		
		UserDTO result = service.signInService(userDto);
		
		if(result != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("mail", result.getMail());
			session.setAttribute("name", result.getName());
			
			response.sendRedirect("index");
		} else {
			request.setAttribute("msg", "로그인 정보가 올바르지 않습니다. 다시 시도해주세요 :) ");
			doGet(request, response);
		}
	}
}
