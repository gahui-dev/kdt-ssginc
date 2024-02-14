<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마당 서점 책 정보</title><style>
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
  	table th, table td {border: 1px solid #000; padding: 8px 10px;}
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
		<%
		 	Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/madang?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
	        String username = "madang";
	        String password = "A55870415b^";
	        Connection con = DriverManager.getConnection(url, username, password);
	        String sql = "select * from book;";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	    	ResultSet rs = pstmt.executeQuery(sql);
		%>

		<table border="1">
			<tr>
				<th>도서 번호</th>
				<th>도서 이름</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
			<% while (rs.next()) { %>
			<tr>
				<td><%=rs.getString("bookid")%></td>
				<td><%=rs.getString("bookname")%></td>
				<td><%=rs.getString("publisher")%></td>
				<td><%=rs.getString("price")%></td>
			</tr>
			<% } %>
		</table>
	</main>
</body>
</html>