package com.jsp.service;

import com.jsp.dao.OrderDAO;
import com.jsp.dto.OrderDTO;

public class OrderService {
	private static final OrderService _instance = new OrderService();
	public static OrderService getInstance() {
		return _instance;
	}
	private OrderDAO dao = OrderDAO.getInstance();
	
	public boolean orderBook(OrderDTO orderDto) {
		if(dao.insertOrder(orderDto) == 1) {
			System.out.println("주문 성공");
			return true;
		} else {
			System.out.println("주문 실패");
			return false;
		}
	}
}
