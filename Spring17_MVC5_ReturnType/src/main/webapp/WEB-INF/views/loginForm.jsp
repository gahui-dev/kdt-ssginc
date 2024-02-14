<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 화면 - get</h2>
	<form action="login" method="get">
		<label>id: <input type="text" name="userid" /> </label>
		<label>pw: <input type="password" name="passwd" /> </label>
		<input type="submit" value="로그인" />
	</form>
	
	<h2>로그인 화면 - post</h2>
	<form action="login" method="post">
		<label>id: <input type="text" name="userid" /> </label>
		<label>pw: <input type="password" name="passwd" /> </label>
		<input type="submit" value="로그인" />
	</form>
	
	<h2>회원가입 화면</h2>
	<form action="member" method="get">
		<label>id: <input type="text" name="userid" /> </label>
		<label>pw: <input type="password" name="passwd" /> </label>
		<label>email1: <input type="text" name="email" /> </label>
		<label>email2: <input type="text" name="email" /> </label>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>