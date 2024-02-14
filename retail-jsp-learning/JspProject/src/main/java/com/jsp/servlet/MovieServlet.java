package com.jsp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.MovieDAO;
import com.jsp.dto.MovieDTO;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/movie")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO dao = MovieDAO.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response, String viewPage) throws ServletException, IOException {
		ArrayList<MovieDTO> movielist = dao.selectMovieInfo();
		request.setAttribute("movielist", movielist);

		RequestDispatcher rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl(viewPage));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response, "movie/movie");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 handleRequest(request, response, "movie/movie_result");
	}

}
