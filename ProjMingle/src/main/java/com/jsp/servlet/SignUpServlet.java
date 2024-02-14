package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.UserDTO;
import com.jsp.service.UserService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        this.service = UserService.getInstance();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("signUp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		System.out.println(mail + password + name);
		
		UserDTO userDto = new UserDTO();
		userDto.setMail(mail);
		userDto.setPassword(password);
		userDto.setName(name);
		
		Boolean result = service.signUpService(userDto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(result) {
			out.println("<script>alert('회원가입 되었습니다. '); location.href='signIn';</script>");
		} else {
			out.println("<script>alert('회원가입 실패하였습니다. ');</script>");
			doGet(request, response);
		}
	}
}
