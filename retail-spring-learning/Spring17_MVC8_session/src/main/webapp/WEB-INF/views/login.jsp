<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>안녕하세요 </h2>
	<p>${ loginInfo.userid}님 환영합니다. </p>
	<ul>
		<li><a href="mypage">mypage</a></li>
		<li><a href="logout">logout</a></li>
	</ul>
</body>
</html>