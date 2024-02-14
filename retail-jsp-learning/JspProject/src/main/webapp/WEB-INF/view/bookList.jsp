<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 구매 </title>
<style>
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
</style>
</head>
<body>
	<header>
		<h1><%= session.getAttribute("username") %> 님, 안녕하세요</h1>
		<nav>
			<ul>
				<li><a href="bookList">도서 구매</a></li>
				<li><a href="ordersList">주문 내역</a></li>
				
			</ul>
		</nav>
	</header>
	<main>
	<h3>도서 정보</h3>
	<form action="<%=request.getContextPath()%>/bookList" method="post">
		<table>
			<tr>
				<th>bookid</th>
				<th>bookname</th>
				<th>publisher</th>
				<th>price</th>
				<th></th>
			</tr>
			<c:forEach var="book" items="${ requestScope.booklist }" varStatus="status">
			<tr>
				<td>${ book.bookid } </td>
				<td>${ book.bookname } </td>
				<td>${ book.publisher } </td>
				<td>${ book.price } </td>
				<td>
					<button type="submit" name="bookid" value="${ book.bookid }">주문하기 </button>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
	</main>
	<script>
	function order(bookid) {
		
		alert(bookid);
	}
	</script>
</body>
</html>