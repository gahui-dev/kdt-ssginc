package com.jsp.dto;

public class OrderDTO {
	private int orderid;
	private int custid;
	private int bookid;
	private String saleprice;
	private String orderdate;
	private String bookname;
	
	public int getOrderid() {
		return orderid;
	}
	
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	} 
	
	public int getCustid() {
		return custid;
	}
	
	public void setCustid(int custid) {
		this.custid = custid;
	}
	
	public int getBookid() {
		return bookid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

}
