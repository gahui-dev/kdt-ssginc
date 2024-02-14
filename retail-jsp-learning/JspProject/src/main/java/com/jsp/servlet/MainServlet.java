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

import com.jsp.service.MemberService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberService memberService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		this.memberService = new MemberService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainServlet.doGet()");
		RequestDispatcher rd;
//		HttpSession session = request.getSession();
//
//		String page = request.getParameter("p");
		
		rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("main"));
		rd.forward(request, response);
		

//		if (session.getAttribute("username") == null) {
//			System.out.println("세션 정보 없음 ");
//			response.sendRedirect("login");
//		} else {
//			switch (page) {
//			case "main":
//				rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("main"));
//				rd.forward(request, response);
//				break;
//			case "book":
//				rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("or"));
//				rd.forward(request, response);
//				break;
//			case "member":
//				request.setAttribute("resultSet", memberService.showUser());
//				// memberService.showUser();
//				System.out.print(memberService.showUser().getClass().getName());
//
//				rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("member"));
//				rd.forward(request, response);
//
//				break;
//			case "logout":
//				session = request.getSession();
//
//				System.out.println(session.getAttribute("username"));
//
//				session.removeAttribute("username");
//				System.out.println(session.getAttribute("username"));
//
//				rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("login"));
//				rd.forward(request, response);
//				break;
//			}
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
