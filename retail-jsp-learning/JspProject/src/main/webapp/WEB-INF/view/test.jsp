<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
table { border: 3px solid #000; border-collapse: collapse; }
table tr th, table tr td { border: 1px solid #000; padding: 10px; }
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
<head>
<meta charset="UTF-8">
<title>Drama List</title>
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
	<h3>requestScope </h3>
	<p>\${ requestScope } : ${ requestScope }</p>
	<p>\${ requestScope.dramaList } : ${ requestScope.dramaList }</p>
	
	<h3>dramaList - c:forEach</h3>
	<table>
		<tr>
			<th>index</th>
			<th>count</th>
			<th>drama</th>
		</tr>
		<c:forEach var="drama" items="${ requestScope.dramaList }" varStatus="status">
		<tr>
			<td>${ status.index }</td>
			<td>${ status.count }</td>
			<td>${ drama }</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>dramaList - c:forTokens</h3>
	<table>
		<tr>
			<th>index</th>
			<th>count</th>
			<th>drama</th>
		</tr>
		<c:forTokens var="drama" items="${ requestScope.dramaTokens }"  delims="," varStatus="status">
		<tr>
			<td>${ status.index }</td>
			<td>${ status.count }</td>
			<td>${ drama }</td>
		</tr>
		</c:forTokens>
	</table>
	</main>
</body>
</html>