<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!-- top.jsp -->

<c:if test="${ empty login }">
	<a href="LoginUIServlet">로그인</a>
	<a href="MemberUIServlet">회원가입</a>
</c:if>

<c:if test="${ !empty login }">
	<a href="LogoutServlet">로그아웃</a>
	<a href="">마이페이지</a>
	<a href="CartListServlet">장바구니</a>
</c:if>

