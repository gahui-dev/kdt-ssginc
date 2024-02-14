package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.CustomerDTO;
import com.jsp.service.LoginService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LoginService loginService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		this.loginService = LoginService.getInstance();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("login"));

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		CustomerDTO customerDto = new CustomerDTO();

		customerDto.setUserid(userid);
		customerDto.setPassword(password);

		CustomerDTO result = loginService.loginCustomer(customerDto);
		if (result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("custid", result.getCustid());
			session.setAttribute("userid", result.getUserid());
			session.setAttribute("name", result.getName());
			
			response.sendRedirect("bookList");
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('fail'); location.href='login';</script>");
			out.flush();
		}
	}

}
