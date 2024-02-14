<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마당 서점 - 도서 구매</title>
<style>
* {margin: 0; padding: 0; box-sizing: border-box;}
body {min-height: 100vh; }
header { width: 100%; background-color: #F4CE14; display: flex; align-items: center; justify-content: space-between; padding: 20px 100px;} 
header h1 {font-size: 1.2rem; }
header ul {display: flex; align-items: center; justify-content: center; gap: 20px;}
header ul li { list-style: none;}
header ul li a {text-decoration: none; color: #000;}
main {margin: 20px auto; width: calc(100% - 200px);}
main h2 {margin: 40px 0; text-align: center}
main ul li {margin-left: 20px;}
table {border: 3px solid #000; border-collapse: collapse; width: 100%; }
table th, table td {border: 1px solid #000; padding: 14px 10px; text-align: center;}
button {border: none; background-color: #F4CE14; border-radius: 4px; padding: 8px 16px;}
</style>
</head>
<body>
<header>
	<h1><%= session.getAttribute("name") %> 님, 안녕하세요</h1>
	<nav>
		<ul>
			<li><a href="bookList">도서 구매</a></li>
			<li><a href="orderList">주문 내역</a></li>
			<li><a href="logout">로그아웃</a></li>
		</ul>
	</nav>
</header>
<main>
<h2>도서 구매</h2>
<table>
	<tr>
		<th>도서 아이디</ths>
        <th>도서명</th>
        <th>출판사</th>
        <th>가격</th>
        <th>주문</th>
    </tr>
<c:forEach var="book" items="${ requestScope.bookInfo }" varStatus="status">
    <tr>
    	<td>${ book.bookid } </td>
        <td>${ book.bookname } </td>
        <td>${ book.publisher } </td>
        <td>${ book.price } </td>
        <td>
            <form action="<%=request.getContextPath()%>/bookList" method="post">
                <input type="hidden" name="pricevalue" value="${ book.price }"/>
                <button type="submit" name="bookid" value="${ book.bookid }">주문하기</button>
            </form>
        </td>
    </tr>
</c:forEach>
</table>
</main>
</body>
</html>