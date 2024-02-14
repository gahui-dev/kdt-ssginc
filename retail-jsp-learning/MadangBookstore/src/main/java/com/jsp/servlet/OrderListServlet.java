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

import com.jsp.dao.OrderDAO;
import com.jsp.dto.OrderDTO;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
	
	private OrderDAO dao = OrderDAO.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
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
		
		ArrayList<OrderDTO> orderInfo = dao.selectOrderInfo((Integer)session.getAttribute("custid"));
		request.setAttribute("orderInfo", orderInfo);
		
		rd = request.getRequestDispatcher(InternalViewResolver.getResolveViewUrl("orderList"));
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
