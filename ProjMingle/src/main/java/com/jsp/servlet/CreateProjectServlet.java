package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.ProjectDTO;
import com.jsp.service.ProjectService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class createProject
 */
@WebServlet("/createProject")
public class CreateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProjectService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProjectServlet() {
        super();
        this.service = ProjectService.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		String name = (String) session.getAttribute("name");
		
		ArrayList<ProjectDTO> projects = service.selectProject(name);
		request.setAttribute("projects", projects);
		
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("createProject"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String title = request.getParameter("title");
		String purpose = request.getParameter("purpose");
		String content = request.getParameter("content");
		String sDate = request.getParameter("s_date");
		String eDate = request.getParameter("e_date");
		
		ProjectDTO projectDto = new ProjectDTO();
		projectDto.setTitle(title);
		projectDto.setPurpose(purpose);
		projectDto.setContent(content);
		projectDto.setsDate(sDate);
		projectDto.seteDate(eDate);
		
		Boolean result = service.createProject(projectDto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(result) {
			out.println("<script>alert('프로젝트가 생성되었습니다. '); location.href='signIn';</script>");
		} else {
			out.println("<script>alert('프로젝트 생성에 실패하였습니다. ');</script>");
			doGet(request, response);
		}
		
		doGet(request, response);
	}

}
