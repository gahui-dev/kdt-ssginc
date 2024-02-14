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

import com.jsp.dto.LoginDTO;
import com.jsp.service.LoginService;
import com.jsp.util.AuthentificationUtil;
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
		this.loginService = new LoginService();
		// TODO Auto-generated constructor stub
	}

	private void doLogOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet.doLogOut()");
		HttpSession session = req.getSession(true);
		AuthentificationUtil.removeAuthentification(session);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet.doGet()");

		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("login"));

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet.doPost()");

		// Logout method
		String method = request.getParameter("_method");
		if (method != null) {
			doLogOut(request, response);
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginDTO loginDto = new LoginDTO();

		loginDto.setUsername(username);
		loginDto.setPassword(password);

//		CustomerEntity entity = service.readUserByUserNameAndPwd();
		boolean success = loginService.findUserAndPwd(loginDto);
		String msg = "아이디어나 패스워드를 확인하시고 다시 로그인 바랍니다. ";
		request.setAttribute("msg", msg);

		if (success) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			msg = "환영합니다." + username + "님";
//			response.sendRedirect("bookList");
			response.sendRedirect("main");
			
			session.setAttribute("msg", msg);

			// 인증 사용자 대해서 main 서비스

		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('fail'); location.href='login';</script>");
			out.flush();

//			RequestDispatcher rd = request.getRequestDispatcher(
//					InternalViewResolver.getResolveViewUrl("login"));
//			
//			rd.forward(request, response);
		}
	}

}
