package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.CustomerDTO;
import com.jsp.service.RegisterService;
import com.jsp.util.InternalViewResolver;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final RegisterService registerService;
       
    /**1
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        this.registerService = RegisterService.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(
				InternalViewResolver.getResolveViewUrl("register"));
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setUserid(userid);
		customerDto.setPassword(password);
		customerDto.setName(name);
		customerDto.setAddress(address);
		customerDto.setPhone(phone);
		
		Boolean success = registerService.registerCustomer(customerDto);
		
		if(success) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('success'); location.href='login';</script>"); 
			out.flush();
		} else {
			System.out.println("회원가입 실패");
		}
	}
}
