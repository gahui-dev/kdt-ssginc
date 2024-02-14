package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberDTO;
import com.jsp.service.MemberService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberService joinService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        this.joinService = new MemberService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinServlet.doGet()");
		
		RequestDispatcher rd = request.getRequestDispatcher(
				InternalViewResolver.getResolveViewUrl("join"));
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinServlet.doPost()");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		MemberDTO joinDto = new MemberDTO();
		
		joinDto.setUsername(username);
		joinDto.setPassword(password);
		
		Boolean success = joinService.joinUser(joinDto);
		
		if(success) {
			System.out.print("성공");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('success'); location.href='login';</script>"); 
			out.flush();
		} else {
			System.out.println("실패");
		}
	}

}
