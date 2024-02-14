<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.jsp.dto.TestMethod" %>
<%@ page import="com.jsp.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마당 서점 회원 정보</title><style>
	* {margin: 0; padding: 0; box-sizing: border-box;}
	body {min-height: 100vh; }
	header { width: 100%; background-color: #F4CE14; display: flex; align-items: center; justify-content: space-between; padding: 20px 100px;} 
	header h1 {font-size: 1.2rem; }
	header ul {display: flex; align-items: center; justify-content: center; gap: 20px;}
	header ul li { list-style: none;}
	header ul li a {text-decoration: none; color: #000;}
	main {margin: 20px auto; width: calc(100% - 200px);}
	main h3 {margin: 20px 0;}
	main ul li {margin-left: 20px;}
	table {border-collapse: collapse; width: 100%; }
   	table tr td:first-child {width: 25%;}
  	table tr td {border: 1px solid #000; padding: 4px 10px;}
</style>
</head>
<body>
	<header>
		<h1><%= session.getAttribute("username") %> 님, 안녕하세요</h1>
		<nav>
			<ul>
				<li><a href="main?p=main">홈</a></li>
				<li><a href="main?p=book">도서 정보</a></li>
				<li><a href="main?p=member">회원 정보</a></li>
				<li><a href="main?p=logout">로그아웃</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<h3>request.getAttribute</h3>
		<p><%=request.getAttribute("resultSet") %></p>
		<h3>JSTL</h3>
		<p><c:out value="${requestScope.resultSet}"></c:out></p>
		<table border="1">
			<tr>
				<th>회원 번호</th>
				<th>회원 아이디</th>
			</tr>
		<c:forEach var="user" items="${ requestScope.resultSet }">
	    	<tr>
				<td><c:out value="${user.mem_seq}"></c:out></td>
				<td><c:out value="${user.username}"></c:out></td>
			</tr>
	    </c:forEach>
		</table>
	</main>
</body>
</html>