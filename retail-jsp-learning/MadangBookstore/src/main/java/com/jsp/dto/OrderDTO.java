package com.jsp.dto;

public class OrderDTO extends BookDTO{
	private int orderid;
	private int custid;
	private int bookid;
	private int saleprice;
	private String orderdate;
	
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
	
	public int getSaleprice() {
		return saleprice;
	}
	
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	
	public String getOrderdate() {
		return orderdate;
	}
	
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}	
}
