package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.PersonDTO;
import com.jsp.service.RegisterService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final RegisterService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		this.service = RegisterService.getInstance();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("register"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int level = Integer.parseInt(request.getParameter("level"));
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");

		PersonDTO personDto = new PersonDTO();

		personDto.setUserid(userid);
		personDto.setPassword(password);
		personDto.setName(name);
		personDto.setLevel(level);
		personDto.setGender(gender);
		personDto.setPhone(phone);

		Boolean success = service.resgisterPerson(personDto);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (success) {
			System.out.println("등록 성공 ");
			out.println("<script>alert('계정이 등록 되었습니다. '); location.href='register';</script>");

		} else {
			System.out.println("등록 실패 ");
			out.println("<script>alert('등록에 실패하였습니다. '); location.href='register';</script>");
		}
		
		out.flush();
		doGet(request, response);
	}
}
