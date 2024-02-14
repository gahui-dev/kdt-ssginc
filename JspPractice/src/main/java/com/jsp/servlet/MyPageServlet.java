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

import com.jsp.dto.PersonDTO;
import com.jsp.service.MyPageService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MyPageService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
    	super();
        this.service = MyPageService.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String userid = (String) session.getAttribute("userid");
		
		PersonDTO result = service.showPerson(userid);
	
		request.setAttribute("userid", result.getUserid());
		request.setAttribute("password", result.getPassword());
		request.setAttribute("name", result.getName());
		request.setAttribute("level", result.getLevel());
		request.setAttribute("gender", result.getGender());
		request.setAttribute("phone", result.getPhone());
		
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("myPage"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
				
		PersonDTO personDto = new PersonDTO();

		personDto.setName(name);
		personDto.setPassword(password);
		personDto.setPhone(phone);
		personDto.setUserid(userid);
		
		Boolean result = service.editPerson(personDto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
				
		if(result) {
			out.println("<script>alert('수정이 완료되었습니다. '); location.href='register';</script>");
		} else {
			out.println("<script>alert('실패했습니다. '); location.href='register';</script>");
		}
		out.flush();
		
		doGet(request, response);
	}

}
