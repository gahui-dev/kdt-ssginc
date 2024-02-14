
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/style.css">
</head>
<body>
	<div id="wrap">
		<form action="${pageContext.request.contextPath}/login" method="post" class="loginForm">
			<h1>LOGIN</h1>
			<div class="radioBox">
				<input type="radio" name="level" id="opt1" value="0" checked>
			    <label for="opt1">
			       <span>운영자</span>
			    </label>
			    <input type="radio" name="level" id="opt2" value="1">
			    <label for="opt2">
			       <span>일반회원</span>
			    </label>
			</div>
			<div>
				<input type="text" name="userid" placeholder="아이디" required>
				<input type="password" name="password" placeholder="비밀번호" required>
			</div>
			<p>${ requestScope.msg }</p>
			<button type="submit">로그인</button>
		</form>
	</div>
</body> 
</html>