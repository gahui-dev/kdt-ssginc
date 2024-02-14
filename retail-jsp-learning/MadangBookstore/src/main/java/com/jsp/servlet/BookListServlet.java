package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.jsp.dto.OrderDTO;
import com.jsp.service.OrderService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderService orderService;
	RequestDispatcher rd;
	
	private BookDAO dao = BookDAO.getInstance();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        this.orderService = OrderService.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("custid") == null) {
			System.out.println("세션 정보 없음");
			response.sendRedirect("login");
		}
		
		ArrayList<BookDTO> bookInfo = dao.selectBookInfo();
		request.setAttribute("bookInfo", bookInfo);
		
		rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("bookList"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int custid = (Integer)session.getAttribute("custid");
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		int price = Integer.parseInt(request.getParameter("pricevalue"));
		
		OrderDTO orderDto = new OrderDTO();
		orderDto.setCustid(custid);
		orderDto.setBookid(bookid);
		orderDto.setSaleprice(price);
		
		Boolean success = orderService.orderBook(orderDto);
		
		if(success) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('success'); location.href='bookList';</script>"); 
			out.flush();
		} else {
			System.out.println("주문 실패");
		}
		
		doGet(request, response);
	}

}
