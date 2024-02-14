package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.MovieService;
import com.jsp.util.InternalViewResolver;
import com.jsp.util.PageMaker;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private MovieDAO dao = MovieDAO.getInstance();
	private final MovieService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        this.service = MovieService.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNum = 1;
		int amount = 10;
		int displayPageAmount = 5;
		
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNo"));
		} catch(Exception e) {}
		
		try {
			amount = Integer.parseInt(request.getParameter("amount"));
		} catch(Exception e) {}
		
		try {
			displayPageAmount = Integer.parseInt(request.getParameter("displayPageAmount"));
		} catch(Exception e) {}
		
		//double totalDataCount = 321;
		
		PageMaker pageMaker = PageMaker.getPageMaker(pageNum);
		pageMaker.setCriteriaAmount(amount);
		pageMaker.setDisplayPageAmount(displayPageAmount);
		
		request.setAttribute("pageMaker", pageMaker);
		request.setAttribute("movielist", service.findMovieByPaging(pageMaker));

		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("test"));
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
