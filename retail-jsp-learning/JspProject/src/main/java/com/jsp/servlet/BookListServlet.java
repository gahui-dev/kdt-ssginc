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

import com.jsp.dao.BookDAO;
import com.jsp.dto.BookDTO;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		session = request.getSession();
		
		if(session.getAttribute("username") == null) {
			System.out.println("세션 정보 없음 ");
			response.sendRedirect("login");
		}
		
		BookDAO bookDao = new BookDAO();
		ArrayList<BookDTO> booklist = bookDao.selectBookInfo();
		
//		if (booklist != null) {
//            for (BookDTO i : booklist) {
//                System.out.print(i.getBookid() + " ");
//                System.out.print(i.getBookname() + " ");
//                System.out.print(i.getPublisher() + " ");
//                System.out.print(i.getPrice() + " ");
//            }
//		}
		
		request.setAttribute("booklist", booklist);
				
		rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("bookList"));
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		System.out.println(bookid);
		
		doGet(request, response);
	}

}
