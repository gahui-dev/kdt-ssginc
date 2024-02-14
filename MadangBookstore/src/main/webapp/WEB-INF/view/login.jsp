<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마당 서점 - 로그인</title>
<style>
	body {height: 100vh; background-color: #f2f3f4; display:flex; align-items:center; justify-content: center; flex-direction: column;}
	.container { padding: 20px 40px; background-color: #fff; border-radius: 12px;  }'
	form { display: flex; flex-direction: column; align-items: center; gap: 20px;}
	form h1 {text-align: center;  margin-bottom: 40px; font-size: 1.8rem;}
	form label {display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;}
	form label span{ width: 40%; display: inline-block; text-align: left;}
	form label input {width: 160px; padding: 4px 8px;} 
	form input[type=submit] { width: 100%; margin: 20px 0 ; border: none; background-color: #F4CE14; border-radius: 4px; padding: 8px 16px;} 
	form ~ a {display: block; text-align: right;} 
</style>
</head>
<body>
<div class="container">
	<form action="<%=request.getContextPath()%>/login" method="post">
		<h1>로그인</h1>
		<label><span>아이디</span> <input type="text" name="userid"></input></label>
		<label><span>비밀번호</span> <input type="password" name="password"></label>
		<input type="submit" value="로그인">
	</form>
	<a href="<%=request.getContextPath()%>/register">회원가입</a>
</div>
</body>
</html>