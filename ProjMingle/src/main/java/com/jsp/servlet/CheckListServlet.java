package com.jsp.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class CheckListServlet
 */
@WebServlet("/checkList")
public class CheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProjectService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckListServlet() {
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
		
		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("checkList"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
